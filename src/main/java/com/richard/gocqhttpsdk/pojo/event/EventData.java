package com.richard.gocqhttpsdk.pojo.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventData {
    private String post_type;
    private long time;
    private long self_id;//机器人的qq号
}
