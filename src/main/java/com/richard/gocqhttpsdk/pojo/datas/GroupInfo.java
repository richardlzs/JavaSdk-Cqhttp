package com.richard.gocqhttpsdk.pojo.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupInfo {
    private long group_id;
    private String group_name;
    private String group_memo;//群备注
    private long group_create_time;//仅在群中时可用
    @Deprecated
    private long group_level;//失效的api
    private int member_count;//仅在群中时可用
    private int max_member_count;//仅在群中时可用
}
