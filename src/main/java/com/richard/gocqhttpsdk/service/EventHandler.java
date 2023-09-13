package com.richard.gocqhttpsdk.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.richard.gocqhttpsdk.pojo.Request;
import com.richard.gocqhttpsdk.pojo.event.*;
import com.richard.gocqhttpsdk.service.Events.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventHandler {
    @Autowired
    private GroupMessageHandler groupMessageHandler;
    @Autowired
    private MetaEventHandler metaEventHandler;
    @Autowired
    private NoticeHandler noticeHandler;
    @Autowired
    private PrivateMessageHandler privateMessageHandler;
    @Autowired
    private RequestHandler requestHandler;

    @Autowired
    private Gson gson;


    public  Request mainHandler(JsonObject jsonObject) {
        switch (jsonObject.get("post_type").getAsString())
        {
            case "message":
                return messageHandler(jsonObject);
            case "message_sent":
                return messageSentHandler(jsonObject);
            case "request":
                return requestHandler(jsonObject);
            case "notice":
                return noticeHandler(jsonObject);
            case "meta_event":
                return metaEventHandler(jsonObject);
            default:
                log.warn("post_type is default case");
                return null;
        }
    }


    private  Request messageHandler(JsonObject jsonObject) {

        switch (jsonObject.get("message_type").getAsString())
        {
            case "private":
                PrivateMessageEventData privateMessageEventData = gson.fromJson(jsonObject, PrivateMessageEventData.class);
                return privateMessageHandler.handler(privateMessageEventData);
            case "group":
                GroupMessageEventData groupMessageEventData = gson.fromJson(jsonObject, GroupMessageEventData.class);
                return groupMessageHandler.handler(groupMessageEventData);
            default:
                log.warn("message_type  is default case");
                return null;
        }
    }

    private Request messageSentHandler(JsonObject jsonObject) {

        //TODO:messageSentHandler
        log.warn("messageSentHandler 尚未开发");
        return null;
    }

    private Request requestHandler(JsonObject jsonObject) {
        RequestEventData requestEventData = gson.fromJson(jsonObject, RequestEventData.class);
        switch (jsonObject.get("request_type").getAsString())
        {
            case "friend":
                return requestHandler.requestFriendHandler(requestEventData);
            case "group":
                return requestHandler.requestGroupHandler(requestEventData);
            default:
                log.warn("request_type is  default case");
                return null;
        }
    }

    private  Request noticeHandler(JsonObject jsonObject) {
        NoticeEventData noticeEventData=gson.fromJson(jsonObject,NoticeEventData.class);
        switch (jsonObject.get("notice_type").getAsString())
        {
            case "group_upload":
                return noticeHandler.groupUploadHandler(noticeEventData);
            case "group_admin":
                return noticeHandler.groupAdminHandler(noticeEventData);
            case "group_decrease":
                return noticeHandler.groupDecreaseHandler(noticeEventData);
            case "group_increase":
                return noticeHandler.groupIncreaseHandler(noticeEventData);
            case "group_ban":
                return noticeHandler.groupBanHandler(noticeEventData);
            case "friend_add":
                return noticeHandler.friendAddHandler(noticeEventData);
            case "group_recall":
                return noticeHandler.friendRecallHandler(noticeEventData);
            case "group_card":
                return noticeHandler.groupCardHaandler(noticeEventData);
            case "offline_file":
                return noticeHandler.offlineFileHandler(noticeEventData);
            case "client_status":
                return noticeHandler.clientStatusHandler(noticeEventData);
            case "essence":
                return noticeHandler.essenceHandler(noticeEventData);
            case "notify":
                return noticeHandler.notifyHandler(noticeEventData);
            default:
                log.warn("notice_type is  default case");
                return null;
        }
    }

    private Request metaEventHandler(JsonObject jsonObject) {
        MetaEventData metaEventData = gson.fromJson(jsonObject, MetaEventData.class);
        switch (jsonObject.get("meta_event_type").getAsString())
        {
            case "heartbeat":
                return metaEventHandler.heartbeatHandler(metaEventData);
            case "lifecycle":
                return metaEventHandler.lifecycleHandler(metaEventData);
            default:
                log.warn("meta_event_type is default case");
                return null;
        }
    }
}
