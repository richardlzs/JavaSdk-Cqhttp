package com.richard.gocqhttpsdk.pojo.event;

public class NoticeEventData extends EventData {

    //通用
    public String notice_type;

    //其他
    //私聊消息撤回
    public long user_id;//也在使用：群消息撤回
    public long message_id;//也在使用：群消息撤回

    //群消息撤回
    public long group_id;
    public long operator_id;//操作者id

    //群成员增加/减少
    public String sub_type;//群成员增加:approve、invite.群成员减少：leave、kick、kick_me//管理员变动：set、unset//群禁言：ban、lift_ban//精华消息变更：add,delete	添加为add,移出为delete

    //群文件上传
    public UploadFileInfo file;

    //群禁言
    public long duration;

    //好友戳一戳（双击头像）
    //分辨是群的戳和好友戳检测group_id 字段
    //发送者id==user_id
    public long target_id;//被戳者id

    //群荣誉
    public String honor_type;//talkative:龙王 performer:群聊之火 emotion:快乐源泉

    //群头衔
    public String title;

    //群名片
    public String card_new;
    public String card_old;


    //其他客户端在线状态变更
    public DeviceInfo client;
    public boolean online;





}
