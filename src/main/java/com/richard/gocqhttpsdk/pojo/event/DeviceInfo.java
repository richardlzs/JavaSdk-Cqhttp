package com.richard.gocqhttpsdk.pojo.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceInfo {
    private long app_id;
    private String device_name;
    private String device_kind;
}
