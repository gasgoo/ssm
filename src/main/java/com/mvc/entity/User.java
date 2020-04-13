package com.mvc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String mobile;

    private String password;

    private Integer age;

    private Date createDate;
    private Date updateDate;
}
