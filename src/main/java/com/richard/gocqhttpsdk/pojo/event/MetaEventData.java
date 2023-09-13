package com.richard.gocqhttpsdk.pojo.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class MetaEventData extends EventData {
    private String meta_event_type;//通用数据
    private Status status;//心跳包
    private long interval;//心跳包
    private String sub_type;//生命周期

}
