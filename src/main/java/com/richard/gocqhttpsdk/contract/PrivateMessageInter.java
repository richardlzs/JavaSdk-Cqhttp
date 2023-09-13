package com.richard.gocqhttpsdk.contract;

import com.richard.gocqhttpsdk.pojo.Request;
import com.richard.gocqhttpsdk.pojo.event.PrivateMessageEventData;

public interface PrivateMessageInter {
    Request privateMessage(PrivateMessageEventData privateMessageEventData);
}
