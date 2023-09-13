package com.richard.gocqhttpsdk.service.Events;

import com.richard.gocqhttpsdk.contract.GroupMessageInter;
import com.richard.gocqhttpsdk.contract.Providers;
import com.richard.gocqhttpsdk.pojo.Request;
import com.richard.gocqhttpsdk.pojo.event.GroupMessageEventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class GroupMessageHandler {


    public GroupMessageHandler(Providers providers) {
        this.groupMessageInter=providers.groupMessageInterProvider();
    }

    private GroupMessageInter groupMessageInter;

    public  Request handler(GroupMessageEventData groupMessageEventData) {
        return groupMessageInter.groupMessage(groupMessageEventData);
    }
}
