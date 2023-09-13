package com.richard.gocqhttpsdk.pojo.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupFileDirectory {
    private List<GroupFile> files;
    private List<GroupFolder> folders;
}
