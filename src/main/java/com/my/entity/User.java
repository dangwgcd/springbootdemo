package com.my.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wt on 2017/12/4.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String mobile;

    public User(String name,Integer age) {
        this.name = name;
        this.age = age;
    }
}
