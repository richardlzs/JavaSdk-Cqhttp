package com.richard.gocqhttpsdk.pojo.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupFolder {
    /*
    group_id	int32	群号
folder_id	string	文件夹ID
folder_name	string	文件名
create_time	int64	创建时间
creator	int64	创建者
creator_name	string	创建者名字
total_file_count	int32	子文件数量
     */
    private long group_id;
    private String folder_id;
    private String folder_name;
    private long create_time;
    private long creator;
    private String creator_name;
    private int total_file_count;
}
