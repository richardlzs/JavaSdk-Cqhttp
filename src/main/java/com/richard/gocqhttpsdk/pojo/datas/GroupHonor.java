package com.richard.gocqhttpsdk.pojo.datas;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 响应数据
 *
 * 字段名	数据类型	说明
 * group_id	int64	群号
 * current_talkative	object	当前龙王, 仅 type 为 talkative 或 all 时有数据
 * talkative_list	array	历史龙王, 仅 type 为 talkative 或 all 时有数据
 * performer_list	array	群聊之火, 仅 type 为 performer 或 all 时有数据
 * legend_list	array	群聊炽焰, 仅 type 为 legend 或 all 时有数据
 * strong_newbie_list	array	冒尖小春笋, 仅 type 为 strong_newbie 或 all 时有数据
 * emotion_list	array	快乐之源, 仅 type 为 emotion 或 all 时有数据
 *
 *
 * 其中 current_talkative 字段的内容如下：
 *
 * 字段名	数据类型	说明
 * user_id	int64	QQ 号
 * nickname	string	昵称
 * avatar	string	头像 URL
 * day_count	int32	持续天数
 *
 *
 * 其它各 *_list 的每个元素是一个 json 对象, 内容如下：
 *
 * 字段名	数据类型	说明
 * user_id	int64	QQ 号
 * nickname	string	昵称
 * avatar	string	头像 URL
 * description	string	荣誉描述
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupHonor {
    @SerializedName("group_id")
    private long groupId;

    @SerializedName("current_talkative")
    private CurrentTalkative currentTalkative;

    @SerializedName("talkative_list")
    private List<HonorData> talkativeList;

    @SerializedName("performer_list")
    private List<HonorData> performerList;

    @SerializedName("legend_list")
    private List<HonorData> legendList;

    @SerializedName("strong_newbie_list")
    private List<HonorData> strongNewbieList;

    @SerializedName("emotion_list")
    private List<HonorData> emotionList;

    @Data
    public static class CurrentTalkative {
        @SerializedName("user_id")
        private long userId;

        @SerializedName("nickname")
        private String nickname;

        @SerializedName("avatar")
        private String avatar;

        @SerializedName("day_count")
        private int dayCount;
    }

    @Data
    public static class HonorData {
        @SerializedName("user_id")
        private long userId;

        @SerializedName("nickname")
        private String nickname;

        @SerializedName("avatar")
        private String avatar;

        @SerializedName("description")
        private String description;
    }
}