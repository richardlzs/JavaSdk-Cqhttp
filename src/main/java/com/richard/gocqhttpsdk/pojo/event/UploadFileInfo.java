package com.richard.gocqhttpsdk.pojo.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadFileInfo {
    private String id;
    private String name;//离线文件也有
    private long size;////离线文件也有
    private long busid;//未知作用（api里面如是说）

    private String url;//离线文件专属
}
