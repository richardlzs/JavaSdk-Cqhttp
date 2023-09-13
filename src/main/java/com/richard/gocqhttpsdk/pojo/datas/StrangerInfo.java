package com.richard.gocqhttpsdk.pojo.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


/*
user_id	int64	QQ 号
nickname	string	昵称
sex	string	性别, male 或 female 或 unknown
age	int32	年龄
qid	string	qid ID身份卡
level	int32	等级
login_days	int32	等级
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrangerInfo {
    private long user_id;
    private String nickname;
    private String sex;
    private int age;
    @Deprecated
    private String qid;
    private int level;
    private int login_days;
}
