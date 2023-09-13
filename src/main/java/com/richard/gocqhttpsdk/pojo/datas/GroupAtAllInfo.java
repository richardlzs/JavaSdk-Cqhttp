package com.richard.gocqhttpsdk.pojo.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupAtAllInfo {
    private boolean can_at_all;
    private Integer remain_at_all_count_for_group;
    private Integer remain_at_all_count_for_uin;
}
