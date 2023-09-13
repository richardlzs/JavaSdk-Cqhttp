package com.richard.gocqhttpsdk.contract;

import com.richard.gocqhttpsdk.pojo.Request;
import com.richard.gocqhttpsdk.pojo.event.*;
import org.springframework.stereotype.Component;

@Component
public class ProvidersMockImpl implements Providers{
    @Override
    public GroupMessageInter groupMessageInterProvider() {
        return new GroupMessageInter() {
            @Override
            public Request groupMessage(GroupMessageEventData groupMessageEventData) {
                return null;
            }
        };
    }

    @Override
    public MetaEventInter metaEventInterProvider() {
        return new MetaEventInter() {
            @Override
            public Request heartbeat(MetaEventData metaEventData) {
                return null;
            }

            @Override
            public Request lifecycle(MetaEventData metaEventData) {
                return null;
            }
        };
    }

    @Override
    public NoticeInter noticeInterProvider() {
        return new NoticeInter() {
            @Override
            public Request groupUpload(NoticeEventData jsonObject) {
                return null;
            }

            @Override
            public Request groupAdmin(NoticeEventData jsonObject) {
                return null;
            }

            @Override
            public Request groupDecrese(NoticeEventData noticeEventData) {
                return null;
            }

            @Override
            public Request groupIncrease(NoticeEventData noticeEventData) {
                return null;
            }

            @Override
            public Request groupBan(NoticeEventData noticeEventData) {
                return null;
            }

            @Override
            public Request friendAdd(NoticeEventData noticeEventData) {
                return null;
            }

            @Override
            public Request friendRecall(NoticeEventData noticeEventData) {
                return null;
            }

            @Override
            public Request groupCard(NoticeInter noticeInter) {
                return null;
            }

            @Override
            public Request offlineFile(NoticeEventData noticeEventData) {
                return null;
            }

            @Override
            public Request clientStatus(NoticeEventData noticeEventData) {
                return null;
            }

            @Override
            public Request essence(NoticeEventData noticeEventData) {
                return null;
            }

            @Override
            public Request notify(NoticeEventData noticeEventData) {
                return null;
            }
        };
    }

    @Override
    public PrivateMessageInter privateMessageInterProvider() {
        return new PrivateMessageInter() {
            @Override
            public Request privateMessage(PrivateMessageEventData privateMessageEventData) {
                return null;
            }
        };
    }

    @Override
    public RequestInter requestInterProvider() {
        return new RequestInter() {
            @Override
            public Request requestFriend(RequestEventData requestEventData) {
                return null;
            }

            @Override
            public Request requestGroup(RequestEventData requestEventData) {
                return null;
            }
        };
    }
}
