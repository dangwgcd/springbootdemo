package com.my.config.es;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by wt on 2017/12/22.
 */
@Configuration
public class EsConfig {

//    @Bean
//    public TransportClient client() throws UnknownHostException {
//        Settings settings = Settings.builder()
//                .put("cluster.name", "wt1")
//                .build();
//
//        TransportClient client = new PreBuiltTransportClient(settings)
//                .addTransportAddress(new TransportAddress(InetAddress.getByName("wt1"), 9300));
//
//
//        return client;
//    }
}
