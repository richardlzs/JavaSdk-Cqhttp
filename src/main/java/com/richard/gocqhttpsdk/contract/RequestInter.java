package com.richard.gocqhttpsdk.contract;

import com.richard.gocqhttpsdk.pojo.Request;
import com.richard.gocqhttpsdk.pojo.event.RequestEventData;

public interface RequestInter {
    Request requestFriend(RequestEventData requestEventData);

    Request requestGroup(RequestEventData requestEventData);
}
