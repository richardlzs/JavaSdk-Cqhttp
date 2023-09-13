package com.richard.gocqhttpsdk.pojo.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupSystemInfo {
    private List<InvitedRequest> invited_requests;
    private List<JoinRequest> join_requests;



    /*
        request_id	int64	请求ID
        invitor_uin	int64	邀请者
        invitor_nick	string	邀请者昵称
        group_id	int64	群号
        group_name	string	群名
        checked	bool	是否已被处理
        actor	int64	处理者, 未处理为0
         */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InvitedRequest {
        private long request_id;
        private long invitor_uin;
        private String invitor_nick;
        private long group_id;
        private String group_name;
        private boolean checked;
        private long actor;
    }

    /*
        request_id	int64	请求ID
        requester_uin	int64	请求者ID
        requester_nick	string	请求者昵称
        message	string	验证消息
        group_id	int64	群号
        group_name	string	群名
        checked	bool	是否已被处理
        actor	int64	处理者, 未处理为0
         */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JoinRequest {
        private long request_id;
        private long requester_uin;
        private String requester_nick;
        private String message;
        private long group_id;
        private String group_name;
        private boolean checked;
    }
}
