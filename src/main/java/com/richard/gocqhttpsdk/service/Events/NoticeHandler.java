package com.richard.gocqhttpsdk.service.Events;

import com.richard.gocqhttpsdk.contract.NoticeInter;
import com.richard.gocqhttpsdk.contract.Providers;
import com.richard.gocqhttpsdk.pojo.Request;
import com.richard.gocqhttpsdk.pojo.event.NoticeEventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoticeHandler {

    public NoticeHandler(Providers providers) {
        this.noticeInter =providers.noticeInterProvider();
    }



    private  NoticeInter noticeInter;

    public Request groupUploadHandler(NoticeEventData noticeEventData) {
        return noticeInter.groupUpload(noticeEventData);
    }

    public Request groupAdminHandler(NoticeEventData noticeEventData) {
        return noticeInter.groupAdmin(noticeEventData);
    }

    public  Request groupDecreaseHandler(NoticeEventData noticeEventData) {
        return noticeInter.groupDecrese(noticeEventData);
    }

    public  Request groupIncreaseHandler(NoticeEventData noticeEventData) {
        return noticeInter.groupIncrease(noticeEventData);
    }

    public  Request groupBanHandler(NoticeEventData noticeEventData) {
        return noticeInter.groupBan(noticeEventData);
    }

    public  Request friendAddHandler(NoticeEventData noticeEventData) {
        return noticeInter.friendAdd(noticeEventData);
    }

    public  Request friendRecallHandler(NoticeEventData noticeEventData) {
        return noticeInter.friendRecall(noticeEventData);
    }

    public  Request groupCardHaandler(NoticeEventData noticeEventData) {
        return noticeInter.groupCard(noticeInter);
    }

    public  Request offlineFileHandler(NoticeEventData noticeEventData) {
        return noticeInter.offlineFile(noticeEventData);
    }

    public  Request clientStatusHandler(NoticeEventData noticeEventData) {
        return noticeInter.clientStatus(noticeEventData);
    }

    public  Request essenceHandler(NoticeEventData noticeEventData) {
        return noticeInter.essence(noticeEventData);
    }

    public  Request notifyHandler(NoticeEventData noticeEventData) {
        return noticeInter.notify(noticeEventData);
    }
}
