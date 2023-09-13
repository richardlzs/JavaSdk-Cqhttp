package com.richard.gocqhttpsdk.pojo.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
file_count	int32	文件总数
limit_count	int32	文件上限
used_space	int64	已使用空间
total_space	int64	空间上限
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupFileSystemInfo {
    private int file_count;
    private int limit_count;
    private long used_space;
    private long total_space;
}
