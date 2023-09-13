package com.richard.gocqhttpsdk.pojo.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class GroupMessageEventData extends EventData {
    private String message_type;
    private String sub_type;
    private long message_id;
    private long user_id;
    private String message;
    private String raw_message;
    private int font;
    private MessageSender sender;
    private long group_id;//群号
    private Anonymous anonymous;
}
