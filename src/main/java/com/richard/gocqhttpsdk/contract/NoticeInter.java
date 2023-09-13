package com.richard.gocqhttpsdk.contract;

import com.richard.gocqhttpsdk.pojo.Request;
import com.richard.gocqhttpsdk.pojo.event.NoticeEventData;


public interface NoticeInter {
     Request groupUpload(NoticeEventData jsonObject);

     Request groupAdmin(NoticeEventData jsonObject);

    Request groupDecrese(NoticeEventData noticeEventData);

    Request groupIncrease(NoticeEventData noticeEventData);

    Request groupBan(NoticeEventData noticeEventData);

    Request friendAdd(NoticeEventData noticeEventData);

    Request friendRecall(NoticeEventData noticeEventData);

    Request groupCard(NoticeInter noticeInter);

    Request offlineFile(NoticeEventData noticeEventData);

    Request clientStatus(NoticeEventData noticeEventData);

    Request essence(NoticeEventData noticeEventData);

    Request notify(NoticeEventData noticeEventData);
}
