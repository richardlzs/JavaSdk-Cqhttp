package com.richard.gocqhttpsdk.pojo.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PrivateMessageEventData extends EventData {
    private String message_type;
    private String sub_type;
    private long message_id;
    private long user_id;
    private String message;
    private String raw_message;
    private int font;
    private MessageSender sender;
    private long target_id;
    private int temp_source;//临时会话来源
}
