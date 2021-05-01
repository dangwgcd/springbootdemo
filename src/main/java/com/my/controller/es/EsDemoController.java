package com.my.controller.es;

import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by wt on 2017/12/23.
 */
@RestController
public class EsDemoController {
//    private Logger logger = LoggerFactory.getLogger(EsDemoController.class);
//
//    @Autowired
//    private TransportClient client;
//
//    @PostMapping(name = "/es_add")
//    public ResponseEntity add(
//            @RequestParam(name = "name") String name,
//            @RequestParam String message,
//            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date publishDate) {
//
//        try {
//            XContentBuilder builder = jsonBuilder()
//                    .startObject()
//                    .field("name", name)
//                    .field("postDate", publishDate)
//                    .field("message", message)
//                    .endObject();
//
//            //如果您需要查看生成的JSON内容，则可以使用该 string()方法
//            String json = builder.string();
//
//            IndexResponse response = this.client.prepareIndex("wt", "ld1").setSource(builder).get();
//
//            return new ResponseEntity(response.getId(), HttpStatus.OK);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
//
//    @GetMapping("es_get")
//    public GetResponse get() {
//
//        GetResponse response = client.prepareGet("wt", "ld1", "_x-riGABChNd7ees8HOR")
//                .setOperationThreaded(false)//operationThreaded被设置为true表示异步执行操作
//                .get();
//
//        return response;
//    }
//
//    @DeleteMapping("es_del")
//    public void del() {
//
//        DeleteRequestBuilder deleteRequestBuilder = client.prepareDelete();
//    }

}
