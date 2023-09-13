package com.richard.gocqhttpsdk.pojo;

import lombok.Data;

@Data
public class Response<T> {
    private String status;
    private Integer retcode;
    private String msg;
    private String wording;
    private T data;
    private String echo;

}
