package com.richard.gocqhttpsdk.pojo.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupMemberInfo {
    private long group_id;
    private long user_id;
    private String nickname;
    private String card;
    private String sex;
    private int age;
    private String area;
    private long join_time;
    private long last_sent_time;
    private String level;
    private String role;
    private boolean unfriendly;
    private String title;
    private long title_expire_time;
    private boolean card_changeable;
    private long shut_up_timestamp;
}

