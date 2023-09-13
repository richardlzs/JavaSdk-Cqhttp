package com.richard.gocqhttpsdk.pojo.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageSender {
    private long user_id;
    private String nickname;
    private String sex;
    private int age;
    private long group_id;//这个只有群临时会话会有这个groupid，群信息没有！！！！
    private String card;
    private String area;
    private String level;
    private String role;
    private String title;

}
