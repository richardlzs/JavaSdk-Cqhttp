package com.richard.gocqhttpsdk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    private String action;
    private Map<String,String> params;
    @Deprecated
    private String echo;//采用post方法，此字段会被丢弃

    public Request(String action, Map<String, String> params) {
        this.action = action;
        this.params = params;
    }
}
