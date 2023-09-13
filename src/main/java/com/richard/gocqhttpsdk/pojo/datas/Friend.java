package com.richard.gocqhttpsdk.pojo.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    private String remark;
    private String nickname;
    private long user_id;
}
