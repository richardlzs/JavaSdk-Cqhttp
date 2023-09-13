package com.richard.gocqhttpsdk.contract;

public interface Providers {
    public GroupMessageInter groupMessageInterProvider();
    public MetaEventInter  metaEventInterProvider();
    public NoticeInter noticeInterProvider();
    public PrivateMessageInter privateMessageInterProvider();
    public RequestInter requestInterProvider();
}
