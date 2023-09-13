package com.richard.gocqhttpsdk.contract;

import com.google.gson.JsonObject;
import com.richard.gocqhttpsdk.pojo.Request;
import com.richard.gocqhttpsdk.pojo.event.MetaEventData;

public interface MetaEventInter {


    Request heartbeat(MetaEventData metaEventData);

    Request lifecycle(MetaEventData metaEventData);
}
