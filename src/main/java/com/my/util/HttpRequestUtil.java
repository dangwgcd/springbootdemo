package com.my.util;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by luohuahua on 17/6/2.
 */
public class HttpRequestUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpRequestUtil.class);

    private static String DEFAULT_CHARSET = "utf-8";

    private static OkHttpClient client;

    static {
        client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    public int maxAttempts = 2;//最大重试次数
                    private int retryNum = 0;

                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Response response = chain.proceed(request);
                        while (!response.isSuccessful() && retryNum < maxAttempts) {
                            retryNum++;
                            response = chain.proceed(request);
                            logger.error("第 {} 次尝试请求 [{}]...", retryNum, request.url());
                        }
                        retryNum = 0;
                        return response;
                    }
                })
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    public static String sendPost(String apiUrl, Map<String, String> params) throws Exception {
        String postDataString = buildQuery(params, DEFAULT_CHARSET);
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, postDataString);
        Request request = new Request.Builder()
                .url(apiUrl)
                .post(requestBody)
                .build();

        String result = null;
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            result = response.body().string();
        }

        return result;
    }

    public static String sendGet(String apiUrl) throws Exception {
        Request request = new Request.Builder().url(apiUrl).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    public static String sendGet(String apiUrl, Map<String, String> params, String charset) throws Exception {
        apiUrl = apiUrl + "?" + buildQuery(params, charset);
//        System.out.println(apiUrl);
        Request request = new Request.Builder().url(apiUrl).build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    private static String buildQuery(Map<String, String> params, String charset) throws IOException {
        if (params == null || params.isEmpty()) {
            return null;
        }

        StringBuilder query = new StringBuilder();
        Set<Map.Entry<String, String>> entries = params.entrySet();
        boolean hasParam = false;

        for (Map.Entry<String, String> entry : entries) {
            String name = entry.getKey();
            String value = entry.getValue();
            // 忽略参数名或参数值为空的参数
            if (isNotEmpty(name) && isNotEmpty(value)) {
                if (hasParam) {
                    query.append("&");
                } else {
                    hasParam = true;
                }

                query.append(name).append("=").append(URLEncoder.encode(value, charset));
            }
        }

        return query.toString();
    }

    private static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private static boolean isNotEmpty(String str) {
        return !HttpRequestUtil.isEmpty(str);
    }

}
