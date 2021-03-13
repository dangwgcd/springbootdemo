package com.my.config.mq;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wt on 2017/12/6.
 */
@Component
@ConfigurationProperties(prefix = "activemq")
@Data
public class MQProperties {
    private String brokerURL;
}
