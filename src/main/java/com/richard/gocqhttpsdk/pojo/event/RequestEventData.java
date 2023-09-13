package com.richard.gocqhttpsdk.pojo.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class RequestEventData extends EventData {
    private String request_type;//friend || group
    //friend情况
    private long user_id;
    private String comment;
    private String flag;
    //group专用的
    private String sub_type;//add || invite
    private long group_id;
}
