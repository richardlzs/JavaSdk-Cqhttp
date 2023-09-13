package com.richard.gocqhttpsdk.pojo.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupNotice {
    private long sender_id;
    private long publish_time;
    private GroupNoticeMsg message;
}
