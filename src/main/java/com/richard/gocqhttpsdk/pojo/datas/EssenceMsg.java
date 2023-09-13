package com.richard.gocqhttpsdk.pojo.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/*
sender_id	int64	发送者QQ 号
sender_nick	string	发送者昵称
sender_time	int64	消息发送时间
operator_id	int64	操作者QQ 号
operator_nick	string	操作者昵称
operator_time	int64	精华设置时间
message_id	int32	消息ID
 */
public class EssenceMsg {
    private long sender_id;
    private String sender_nick;
    private long sender_time;
    private long operator_id;
    private String operator_nick;
    private long operator_time;
    private int message_id;
}
