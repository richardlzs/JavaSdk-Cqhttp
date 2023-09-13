package com.richard.gocqhttpsdk.service.Events;

import com.richard.gocqhttpsdk.contract.Providers;
import com.richard.gocqhttpsdk.contract.RequestInter;
import com.richard.gocqhttpsdk.pojo.Request;
import com.richard.gocqhttpsdk.pojo.event.RequestEventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RequestHandler {

    public RequestHandler(Providers providers) {
        this.requestInter =providers.requestInterProvider();
    }

    private  RequestInter requestInter;

    public  Request requestFriendHandler(RequestEventData requestEventData) {
        return requestInter.requestFriend(requestEventData);
    }

    public  Request requestGroupHandler(RequestEventData requestEventData) {
        return requestInter.requestGroup(requestEventData);
    }
}
