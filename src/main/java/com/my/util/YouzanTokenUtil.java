package com.my.util;


import com.alibaba.fastjson.JSON;
import com.youzan.open.sdk.client.oauth.OAuth;
import com.youzan.open.sdk.client.oauth.OAuthContext;
import com.youzan.open.sdk.client.oauth.OAuthFactory;
import com.youzan.open.sdk.client.oauth.OAuthType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wt on 2017/8/7.
 */
public class YouzanTokenUtil {
    private static Prop prop = new Prop("common.properties", "UTF-8");
    private static String client_id = prop.get("youzan.token.client_id");
    private static String client_secret = prop.get("youzan.token.client_secret");
    private static String kdt_id = prop.get("youzan.token.kdt_id");


    public static String getToken() throws Exception {
        OAuth oauth = OAuthFactory.create(OAuthType.SELF, new OAuthContext(client_id,client_secret,Long.parseLong(kdt_id) ));
        return oauth.getToken().getAccessToken();
    }

    public static void main(String[] args) throws Exception {
        String token = YouzanTokenUtil.getToken();
        System.out.println(token);
    }
}
