package com.richard.gocqhttpsdk.util;

import com.google.gson.Gson;
import com.richard.gocqhttpsdk.pojo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class QuickParser {
    @Autowired
    private Gson gson;
    public <T> T getData(Response<T> response)
    {
        if (response.getStatus().equals("OK"))
        {
            return response.getData();
        }else
        {
            log.error("reponse 显示：调用错误，详情："+response.toString());
            return null;
        }
    }

    public Map<String,String> getDataAsMap(Response<Map<String,String>> response)
    {
        if (response.getStatus().equals("OK"))
        {
           return response.getData();
        }else
        {
            log.error("reponse 显示：调用错误，详情："+response.toString());
            return null;
        }
    }
}
