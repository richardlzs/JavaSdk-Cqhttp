package com.richard.gocqhttpsdk.pojo.datas;

import com.richard.gocqhttpsdk.pojo.event.MessageSender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private boolean group;
    private Long group_id;//是群消息时的群号(否则不存在此字段)
    private Integer message_id;
    private Integer real_id;
    private String message_type;//群消息时为group, 私聊消息为private
    private Integer message_seq;
    private Sender sender;
    private Integer time;
    private String message;
    private String raw_message;

}
