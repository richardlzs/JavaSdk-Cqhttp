package com.richard.gocqhttpsdk.contract;

import com.richard.gocqhttpsdk.pojo.Request;
import com.richard.gocqhttpsdk.pojo.event.GroupMessageEventData;

public interface GroupMessageInter {

    Request groupMessage(GroupMessageEventData groupMessageEventData);
}
