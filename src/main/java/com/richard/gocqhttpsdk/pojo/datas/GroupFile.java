package com.richard.gocqhttpsdk.pojo.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
group_id	int32	群号
file_id	string	文件ID
file_name	string	文件名
busid	int32	文件类型
file_size	int64	文件大小
upload_time	int64	上传时间
dead_time	int64	过期时间,永久文件恒为0
modify_time	int64	最后修改时间
download_times	int32	下载次数
uploader	int64	上传者ID
uploader_name	string	上传者名字
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupFile {
    private long group_id;
    private String file_id;
    private String file_name;
    private int busid;
    private long file_size;
    private long upload_time;
    private long dead_time;
    private long modify_time;
    private int download_times;
    private long uploader;
    private String uploader_name;
}
