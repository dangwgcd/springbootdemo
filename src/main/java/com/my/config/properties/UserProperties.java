package com.my.config.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wt on 2017/12/4.
 */
@Component
@ConfigurationProperties(prefix = "user1")
@Data
public class UserProperties {
    private String name;
    private Integer age;
    private String content;
}
