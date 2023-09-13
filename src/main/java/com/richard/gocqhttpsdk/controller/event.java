package com.richard.gocqhttpsdk.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.richard.gocqhttpsdk.pojo.Request;
import com.richard.gocqhttpsdk.service.EventHandler;
import com.richard.gocqhttpsdk.util.QHttp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class event {

    @Autowired
    private Gson gson;

    @Autowired
    private EventHandler eventHandler;



    @PostMapping("/")
    public void receive(@RequestBody String jsonstr)
    {
        JsonObject jsonObject = JsonParser.parseString(jsonstr).getAsJsonObject();
        if (jsonObject.get("post_type").getAsString().equals("meta_event"))
        {
            log.debug(jsonObject.get("post_type")+jsonObject.toString());
        }else
        {
            log.info(jsonObject.get("post_type")+jsonObject.toString());
        }

        Request request = eventHandler.mainHandler(jsonObject);
    }
}
