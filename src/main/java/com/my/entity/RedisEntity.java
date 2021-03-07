package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by wt on 2017/12/5.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisEntity implements Serializable {
    private static final long serialVersionUID = -1L;

    private String name;
    private Integer age;
}
