package com.richard.gocqhttpsdk.service.Events;

import com.richard.gocqhttpsdk.contract.PrivateMessageInter;
import com.richard.gocqhttpsdk.contract.Providers;
import com.richard.gocqhttpsdk.pojo.Request;
import com.richard.gocqhttpsdk.pojo.event.PrivateMessageEventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrivateMessageHandler {

    public PrivateMessageHandler(Providers providers) {
        this.privateMessageInter = providers.privateMessageInterProvider();
    }

    private  PrivateMessageInter privateMessageInter;
    public  Request handler(PrivateMessageEventData privateMessageEventData) {
        return privateMessageInter.privateMessage(privateMessageEventData);
    }
}
