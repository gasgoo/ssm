package com.mvc.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Message implements Serializable {

    private Long id;

    private String commend;
    private String desc;
    private String content;


}
