package com.richard.gocqhttpsdk.service.Events;

import com.google.gson.Gson;
import com.richard.gocqhttpsdk.contract.MetaEventInter;
import com.richard.gocqhttpsdk.contract.Providers;
import com.richard.gocqhttpsdk.pojo.Request;
import com.richard.gocqhttpsdk.pojo.event.MetaEventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MetaEventHandler {


    public MetaEventHandler(Providers providers) {
        this.metaEventInter =  providers.metaEventInterProvider();
    }


    private MetaEventInter metaEventInter;


    public Request heartbeatHandler(MetaEventData metaEventData) {

        return metaEventInter.heartbeat(metaEventData);
    }

    public Request lifecycleHandler(MetaEventData metaEventData) {
        return metaEventInter.lifecycle(metaEventData);
    }
}
