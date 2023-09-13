package com.richard.gocqhttpsdk.api;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.richard.gocqhttpsdk.pojo.datas.*;
import com.richard.gocqhttpsdk.util.QHttp;
import com.richard.gocqhttpsdk.util.QuickParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class Contact {

    @Autowired
    private QHttp qHttp;

    @Autowired
    private QuickParser quickParser;

    @Autowired
    private Gson gson;

    private final String  encode_type="UTF-8";


    /**
     * @return 登录的账号名
     */
    public String getLoginName() {
        String endpoint="get_login_info";
        Map<String,String> map = qHttp.post(endpoint);
        String name=map.get("nickname").toString();
        return name;
    }

    /**
     * @return 登录的QQ号:int
     */
    public Long getLoginQqId() {
        String endpoint="get_login_info";
        Map<String,String> map = qHttp.post(endpoint);
        Long id= Long.valueOf(map.get("user_id"));
        return id;
    }

    /**
     * 设置用户名
     * @param name 用户名
     */
    public boolean setNickName(String name)
    {
        try {
            String endpoint="set_qq_profile";
            qHttp.post(endpoint, "nickname", name);
            return true;
        }catch (Exception e)
        {
            log.error(e.toString());
            return false;
        }
    }

    /**
     * 设置登录号公司名
     * @param company 公司名
     */
    public boolean setCompany(String company)
    {
        try {
            String endpoint="set_qq_profile";
            qHttp.post(endpoint, "company", company);
            return true;
        }catch (Exception e)
        {
            log.error(e.toString());
            return false;
        }
    }

    /**
     * 设置登录号邮箱
     * @param email 邮箱
     */
    public boolean setEmail(String email)
    {
        try {
            String endpoint="set_qq_profile";
            qHttp.post(endpoint, "email", email);
            return true;
        }catch (Exception e)
        {
            log.error(e.toString());
            return false;
        }
    }

    /**
     * 设置登录号学校
     * @param college 学校
     */
    public boolean setCollege(String college)
    {
        try {
            String endpoint="set_qq_profile";
            qHttp.post(endpoint, "college", college);
            return true;
        }catch (Exception e)
        {
            log.error(e.toString());
            return false;
        }
    }


    /**
     * 设置登录号个人说明
     * @param personal_note 个人说明
     */
    public boolean setPersonalNote(String personal_note)
    {
        try {
            String endpoint="set_qq_profile";
            qHttp.post(endpoint, "personal_note", personal_note);
            return true;
        }catch (Exception e)
        {
            log.error(e.toString());
            return false;
        }
    }

    //TODO:获取、设置在线机型(似乎对应接口被弃用)

    /**
     * 获取陌生人账号昵称
     *
     * @param id 对方qq号
     * @return 对应qq号昵称
     */
    public String getStrangerNicknameByQqId(long id) {
        String endpoint="get_stranger_info";
        Map<String,String> map=qHttp.post(endpoint,"user_id",String.valueOf(id));
        String name=map.get("nickname");
        return name;
    }

    public StrangerInfo getStrangerInfo(long user_id)
    {
        String endpoint="get_stranger_info";
        return qHttp.postForT(endpoint, StrangerInfo.class, "user_id", String.valueOf(user_id));
    }


    /**
     * @return 好友列表
     */
    public List<Friend> getFriendList() {
        String endpoint="get_friend_list";

        return qHttp.postForArrayList(endpoint, Friend.class);
    }

    /**
     * 获取单向好友列表
     * @return 单向好友列表
     */
    public List<Friend> getUnidirectionalFriendList(){
        String endpoint="get_unidirectional_friend_list";
        return qHttp.postForArrayList(endpoint,Friend.class);
    }


    /**
     * 删除好友
     *
     * @param id QQ号
     * @return 删除是否成功:boolean
     */
    public boolean deleteFriend(long id) {
        String endpoint="delete_friend";
        boolean flag = qHttp.postForSuccess(endpoint, "user_id", String.valueOf(id));
        return flag;

    }


    /**
     * 给好友发消息
     *
     * @param id      好友qq号
     * @param message 信息
     * @return message_id；long
     */
    public Integer sendPrivateMsg(long id, String message) {

        String endpoint="send_private_msg";
        Map<String, String> map = qHttp.post(endpoint, "user_id", Long.toString(id), "message", message);
        if (map==null)return null;
        return Integer.valueOf(map.get("message_id"));
    }

    /**
     * 通过群临时会话发送信息给指定人
     * 默认关闭，据说容易封号
     * 要使用请在config.yml中修改allow-temp-session参数 改为true即可
     * 注意：如果双方是好友，group_id随意指定也能发送
     *
     * @param id
     * @param group_id
     * @param message
     * @return
     */
    @Deprecated(forRemoval = false)
    public Integer sendPrivateMsgThroughGroup(long id, long group_id, String message) {
        String endpoint="send_private_msg";
        Map<String, String> map = qHttp.post(endpoint, "user_id",Long.toString(id), "group_id", Long.toString(group_id),  "message", message);
        if (map==null)return null;
        return Integer.valueOf(map.get("message_id"));
    }


    /**
     * 发送群组消息
     *
     * @param group_id
     * @param message
     * @return
     */
    public Integer sendGroupMsg(long group_id, String message) {
        String endpoint="send_msg";
        Map<String, String> map = qHttp.post(endpoint, "group_id", Long.toString(group_id), "message", message);
        if (map==null)return null;
        return Integer.valueOf(map.get("message_id"));

    }



    /**
     * 按message_id查询对应message
     *
     * @param msg_id
     * @return
     */
    public Message getMsg(long msg_id) {

        String endpoint="get_msg";
        Message message = qHttp.postForT(endpoint, Message.class, "message_id", Long.toString(msg_id));
        if (message==null)return null;
        return message;

    }

    /**
     * 撤回消息
     *
     * @param msg_id 消息id
     * @return boolean：是否成功撤回
     */
    public boolean deleteMsg(long msg_id) {
        String endpoint="delete_msg";
        return qHttp.postForSuccess(endpoint,"message_id", Long.toString(msg_id));

    }


    /**
     * 标记消息已读
     * @param message_id  消息id
     * @return 是否成功撤回
     */
    public boolean markMsgAsRead(int message_id)
    {
        String endpoint="mark_msg_as_read";
        return qHttp.postForSuccess(endpoint,"message_id", String.valueOf(message_id));
    }

    //TODO:获取合并转发内容,发送合并转发 ( 群聊 ),发送合并转发 ( 好 )
    // 容易风控暂时不想实现


    /**
     * 获取群消息历史记录
     * @param group_id 群组号
     * @return 群消息历史记录
     */
    public List<Message> getGroupMsgHistory(long group_id)
    {
        String endpoint="get_group_msg_history";
        JsonObject jsonObject = qHttp.postForT(endpoint, JsonObject.class,"group_id",String.valueOf(group_id));
        JsonElement messageJson = jsonObject.get("message");
        TypeToken<ArrayList<Message>> typeToken = new TypeToken<>() {};
        return gson.fromJson(messageJson, typeToken);
    }

    /**
     * 获取图片信息
     *
     * @param file 文件缓存文件名
     * @return FileInfo
     * size	int32	图片源文件大小
     * filename	string	图片文件原名
     * url	string	图片下载地址
     */
    public FileInfo getImage(String file) {

        String endpoint="get_image";
        FileInfo fileInfo = qHttp.postForT(endpoint, FileInfo.class, "file", file);
        return fileInfo;

    }

    /**
     * 获取能否发送图片
     *
     * @return
     */
    public boolean canSendImage() {

        String endpoint="can_send_image";
        return qHttp.postForSuccess(endpoint);

    }


    /**
     * 图片OCR
     * @param imageID 图片id
     * @return OCRResponse
     */
    public OCRResponse OCR(String imageID)
    {
        String endpoint="ocr_image";
        return qHttp.postForT(endpoint, OCRResponse.class, "image", imageID);
    }


    //TODO:语音（不实用，暂时不做）

    /**
     * 检查是否可以发送语音
     */
    public boolean canSenRecord()
    {
        String endpoint="can_send_record";
        return qHttp.postForSuccess(endpoint);
    }


    /**
     * 处理好友添加请求（添加好友）
     *
     * @param flag
     * @param approve
     */
    public boolean setFriendAddRequest(String flag, boolean approve, String remark) {

        String endpoint="set_friend_add_request";
        return qHttp.postForSuccess(endpoint,"flag", flag, "approve", String.valueOf(approve), "remark", remark);
    }


    public boolean setFriendAddRequest(String flag, boolean approve) {

        return setFriendAddRequest(flag,approve,null);
    }

    /**
     * 处理加群请求和邀请本机加群请求
     *
     * @param flag     上报的flag
     * @param sub_type 上报的sub_type //add 或 invite, 请求类型（需要和上报消息中的 sub_type 字段相符）
     * @param approve  boolean 是否同意
     * @param reason   理由，仅拒绝时候生效
     * @return 是否成功加群
     */
    public boolean setGroupAddRequest(String flag, String sub_type, boolean approve, String reason) {

        String endpoint="set_group_add_request";
        return qHttp.postForSuccess(endpoint,"flag",flag,"sub_type",sub_type,"approve", String.valueOf(approve),"reason",reason);
    }

    public boolean allowGroupAddRequest(String flag, String sub_type)
    {
        return setGroupAddRequest(flag,sub_type,true,null);
    }
    public boolean denyGroupAddRequest(String flag, String sub_type, String reason)
    {
        return setGroupAddRequest(flag,sub_type,false,reason);
    }

    /**
     * 获取群信息
     * @param group_id 群号
     * @return 群信息
     *  字段名	数据类型	说明
     * group_id	int64	群号
     * group_name	string	群名称
     * group_memo	string	群备注 //似乎无效
     * group_create_time	uint32	群创建时间 //似乎无效
     * group_level	uint32	群等级 //似乎无效
     * member_count	int32	成员数
     * max_member_count	int32	最大成员数（群容量）
     *
     */
    public GroupInfo getGroupInfo(long group_id, boolean no_cache)
    {


        String endpoint="get_group_info";
        GroupInfo groupInfo = qHttp.postForT(endpoint, GroupInfo.class,
                "group_id", Long.toString(group_id), "no_cache", String.valueOf(no_cache));
        return groupInfo;
    }

    /**
     * 获取群列表
     * @param no_cache 是否不使用缓存
     * @return List<GroupInfo>
     */
    public List<GroupInfo> getGroupList(boolean no_cache)
    {

        String endpoint="get_group_list";
        List<GroupInfo> groupsInfo=qHttp.postForArrayList(endpoint,GroupInfo.class,"no_cache", String.valueOf(no_cache));
        return groupsInfo;
    }

    /**
     * 获取群成员信息
     * @param group_id 群号
     * @param user_id 成员qq号
     * @param no_cache 是否不使用缓存
     * @return 整个GroupMemberInfo
     */
    public GroupMemberInfo getGroupMemberInfo(long group_id, long user_id, boolean no_cache)
    {
        String endpoint="get_group_member_info";
        GroupMemberInfo groupMemberInfo = qHttp.postForT(endpoint, GroupMemberInfo.class,
                "group_id", Long.toString(group_id), "user_id", Long.toString(user_id), "no_cache", String.valueOf(no_cache));
        return groupMemberInfo;
    }

    /**
     * 获取群聊成员列表
     * @param group_id 群号
     * @param no_cache 是否不使用缓存
     * @return List<GroupMember>
     */
    public List<GroupMemberInfo> getGroupMemberList(long group_id, boolean no_cache)
    {

        String endpoint="get_group_member_list";
        List<GroupMemberInfo> groupMembersInfo = qHttp.postForArrayList(endpoint, GroupMemberInfo.class,
                "group_id", Long.toString(group_id), "no_cache", String.valueOf(no_cache));
        return groupMembersInfo;
    }

    /**
     * @param group_id 群号
     * @return
     *
     * 响应数据
     *
     * 字段名	数据类型	说明
     * group_id	int64	群号
     * current_talkative	object	当前龙王,
     * talkative_list	array	历史龙王,
     * performer_list	array	群聊之火,
     * legend_list	array	群聊炽焰,
     * strong_newbie_list	array	冒尖小春笋
     * emotion_list	array	快乐之源,
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

    public GroupHonor getGroupHonor(long group_id)
    {
        String endpoint="get_group_honor_info";
        return qHttp.postForT(endpoint,GroupHonor.class,"group_id",String.valueOf(group_id),"type","all");
    }

    /**
     * 获取群系统消息
     * @return 获取群系统消息
     */
    public GroupSystemInfo getGroupSystemMsg()
    {
        String endpoint="get_group_system_msg";
        return qHttp.postForT(endpoint, GroupSystemInfo.class);
    }



    public List<EssenceMsg> getEssenceMsgList(long group_id)
    {
        String endpoint="get_essence_msg_list";
        return qHttp.postForArrayList(endpoint,EssenceMsg.class,"group_id",String.valueOf(group_id));
    }





    /**
     * 获取群 @全体成员 剩余次数
     * 一个群里面，全部管理一天最多10次@all。一个人在多个群最多也是10次。
     *
     */
    public GroupAtAllInfo getGroupAtAllRemain(long group_id)
    {
        String endpoint="get_group_at_all_remain";
        GroupAtAllInfo info = qHttp.postForT(endpoint, GroupAtAllInfo.class, "group_id", Long.toString(group_id));
        return info;
    }

    /**
     * 设置群名称
     * @apiNote 在cq终端不会显示你修改了群名
     * @param group_id 群号
     * @param group_name 新的群名
     * @return 是否设置成功
     */
    public boolean setGroupName(long group_id, String group_name)
    {

        String endpoint="set_group_name";
        boolean flag=qHttp.postForSuccess(endpoint,"group_id",Long.toString(group_id),"group_name",group_name);
        return flag;
    }


    /**
     * 设置群头像
     * @param group_id 群号
     * @param file URL形式的路径
     * @param cache 是否使用缓存
     * @return 是否成功调用
     */
    public boolean setGroupPortrait(long group_id,String file,boolean cache)
    {
        String endpoint="set_group_portrait";
        int intCache=(cache)?1:0;
        return qHttp.postForSuccess(endpoint,"group_id", String.valueOf(group_id),"file",file,"cache", String.valueOf(intCache));
    }

    /**
     * 设置群管理员
     * @param group_id 群号
     * @param user_id 群员qq号
     * @param enable true 为设置, false 为取消
     * @return 成功执行返回true
     */
    public boolean setGroupAdmin(long group_id, long user_id, boolean enable)
    {

        String endpoint="set_group_admin";
        return qHttp.postForSuccess(endpoint,"group_id",Long.toString(group_id),"user_id",Long.toString(user_id),"enable", String.valueOf(enable));
    }

    /**
     * 设置群名片 ( 群备注 )
     * @param group_id 群号
     * @param user_id 群成员的qq号
     * @param nickname 群昵称
     * @return 是否成功调用
     */
    public boolean setGroupCard(long group_id, long user_id, String nickname)
    {

        String endpoint="set_group_card";
        return qHttp.postForSuccess(endpoint,"group_id",Long.toString(group_id),"user_id",Long.toString(user_id),"card",nickname);

    }

    /**
     * 设置群专属头衔
     * @param group_id 群号
     * @param user_id 群员qq号
     * @param special_title 专属头衔
     * @return 是否设置成功专属头衔
     */
    public boolean setGroupSpecialTitle(long group_id, long user_id, String special_title)
    {

        String endpoint ="set_group_special_title";
        return qHttp.postForSuccess(endpoint,"group_id",Long.toString(group_id),"user_id",Long.toString(user_id),"special_title",special_title);
    }

    /**
     * 群单人禁言
     * @param group_id 群号
     * @param user_id 要禁言的qq号
     * @param durationSeconds 时间（秒），0为取消禁言
     * @return 是否执行成功
     */
    public boolean setGroupBan(long group_id, long user_id, int durationSeconds)
    {

        String endpoint="set_group_ban";
        return qHttp.postForSuccess(endpoint,"group_id",Long.toString(group_id),"user_id",Long.toString(user_id),"duration", String.valueOf(durationSeconds));
    }


    /**
     * 群全员禁言
     * @param group_id 群号
     * @param enable 是否开启全员禁言
     * @return 是否成功执行
     */
    public boolean setGroupWholeBan(long group_id, boolean enable)
    {

        String endpoint="set_group_whole_ban";
        return qHttp.postForSuccess(endpoint,"group_id", String.valueOf(group_id),"enable", String.valueOf(enable));
    }

    /**
     * 群匿名用户禁言
     * @param group_id 群号
     * @param anonymous_flag 匿名用户flag，在上报中获得
     * @param duration 时长
     * @return 是否顺利执行
     */
    @Deprecated
    public boolean setGroupAnonymousBan(long group_id, String anonymous_flag , int duration)
    {
        String endpoint="set_group_anonymous_ban";
        return qHttp.postForSuccess(endpoint,"group_id", String.valueOf(group_id),
                "anonymous_flag",anonymous_flag,"duration", String.valueOf(duration));
    }

    /**
     * 设置精华消息
     * @param message_id 信息id，需要在上报中获得
     * @return 是否成功执行
     */
    public boolean setEssenceMsg(long message_id)
    {
        String endpoint="set_essence_msg";
        return qHttp.postForSuccess(endpoint,"message_id", String.valueOf(message_id));
    }


    /**
     * 删除精华消息
     * @param message_id 信息id，需要在上报中获得
     * @return 是否成功执行
     */
    @Deprecated
    public boolean deleteEssenceMsg(long message_id)
    {

        String endpoint="delete_essence_msg";
        return qHttp.postForSuccess(endpoint,"message_id", String.valueOf(message_id));
    }

    /**
     * 群打卡/群签到
     * @param group_id 群号
     * @return 是否成功调用
     */
    public boolean sendGroupSign(long group_id)
    {
        String endpoint="send_group_sign";
        return qHttp.postForSuccess(endpoint,"group_id", String.valueOf(group_id));
    }

    /**
     * 启用群匿名
     * @param group_id 群号
     * @param enable 是否启用
     * @return 是否成功调用
     */
    public boolean setGroupAnonymous(long group_id, boolean enable)
    {

        String endpoint="set_group_anonymous";
        return qHttp.postForSuccess(endpoint,"group_id", String.valueOf(group_id),"enable", String.valueOf(enable));
    }

    /**
     * 发送群公告
     * @param group_id 群号
     * @param content 内容
     * @param image 照片路径
     * @return 是否成功调用
     */
    public boolean sendGroupNotice(long group_id, String content, @Nullable String image)
    {
        String endpoint="_send_group_notice";
        if (image!=null)
            return qHttp.postForSuccess(endpoint, "group_id", String.valueOf(group_id), "content", content,"image",image);
        else
            return qHttp.postForSuccess(endpoint, "group_id", String.valueOf(group_id), "content", content);
    }

    /**
     * 获得群公告
     * @param group_id 群号
     * @return 返回的apijson的data里面含有以下数据：
     *
     *<p>
     * 响应内容为 json 数组，每个元素内容如下：
     *
     * sender_id	int64	公告发表者
     * publish_time	int64	公告发表时间
     * message	object	公告内容</p>
     *
     * <p>其中 message 字段的内容如下：
     * text	string	公告内容
     * images	array	公告图片
     * </p>
     *
     * <p>其中 images 字段每个元素内容如下：
     * height	string	图片高度
     * width	string	图片宽度
     * id	string	图片ID
     * </p>
     */
    public List<GroupNotice> getGroupNotice(long group_id)
    {

        String endpoint="_get_group_notice";
        return qHttp.postForArrayList(endpoint,GroupNotice.class,"group_id", String.valueOf(group_id));

    }

    /**
     * 群组踢人
     * @param group_id 群号
     * @param user_id 要踢的人q号
     * @param reject_add_request 是否拒绝此人以后加入
     * @return 是否成功调用
     */
    public boolean setGroupKick(long group_id, long user_id, boolean reject_add_request)
    {

        String endpoint="set_group_kick";
        return qHttp.postForSuccess(endpoint,"group_id", String.valueOf(group_id),"user_id", String.valueOf(user_id),"reject_add_request", String.valueOf(reject_add_request));
    }

    /**
     * 退出群聊
     * @param group_id 群号
     * @param is_dismiss 是否解散群聊（群主生效）
     * @return 是否成功执行
     */
    public boolean setGroupLeave(long group_id, boolean is_dismiss)
    {
        String endpoint="set_group_leave";
        return qHttp.postForSuccess(endpoint,"group_id", String.valueOf(group_id),"is_dismiss", String.valueOf(is_dismiss));
    }

    /**
     * 上传群文件（不支持ipv6）
     * @param group_id 群号
     * @param file 本地文件路径
     * @param name 上传的群文件名
     * @param folder 上传的群文件夹
     * @return 是否正常运行
     */
    public boolean uploadGroupFile(long group_id, String file, String name,@Nullable String folder)
    {

        String endpoint="upload_group_file";
        if (folder==null)
            return  qHttp.postForSuccess(endpoint,"group_id", String.valueOf(group_id),"file",file,"name",name);
        else
            return qHttp.postForSuccess(endpoint,"group_id", String.valueOf(group_id),"file",file,"name",name,"e_folder",folder);
    }


    /**
     *上传私聊文件
     * @param user_id 对方q号
     * @param file 本地文件路径
     * @param name 文件名
     * @return 是否成功执行
     */
    public boolean uploadPrivateFile(long user_id, String file, String name)
    {
        String endpoint="upload_private_file";
        return qHttp.postForSuccess(endpoint,"user_id",Long.toString(user_id),"file",file,"name",name);

    }



    /**
     * 删除群文件
     * @param group_id 群号
     * @param file_id 文件id
     * @param busid 文件类型
     * @return 是否成功
     */
    public boolean deleteGroupFile(long group_id,String file_id,String busid)
    {
        String endpoint="delete_group_file";
        return qHttp.postForSuccess(endpoint,"group_id", String.valueOf(group_id),
                "file_id",file_id,"busid",busid);
    }

    /**
     * 创建群文件夹（只能在根目录下）
     * @param group_id 群号
     * @param name 文件夹名
     * @return 是否成功调用
     */
    public boolean createGroupFileFolder(long group_id,String name)
    {
        String endpoint="create_group_file_folder";
        return qHttp.postForSuccess(endpoint,"group_id",String.valueOf(group_id),"name",name,"parent_id","/");
    }

    /**
     * 删除群文件文件夹
     * @param group_id 群号
     * @param folder_id 文件夹ID
     * @return 是否成功调用
     * @apiNote 如果文件夹里面有文件，会被直接删除
     */
    public boolean deleteGroupFolder(long group_id,String folder_id)
    {
        String endpoint="delete_group_folder";
        return qHttp.postForSuccess(endpoint,"group_id",String.valueOf(group_id),"folder_id",folder_id);
    }

    /**
     * 获取群文件系统信息
     * @param group_id 群号
     * @return GroupFileSystemInfo 注意，大小以B为单位
     */
    public GroupFileSystemInfo getGroupFileSystemInfo(long group_id)
    {
        String endpoint="get_group_file_system_info";
        return qHttp.postForT(endpoint,GroupFileSystemInfo.class,"group_id",String.valueOf(group_id));
    }

    /**
     * 获取群根目录文件列表
     * @param group_id 群号
     * @return 群根目录文件列表
     */
    public GroupFileDirectory getGroupRootFiles(long group_id)
    {
        String endpoint="get_group_root_files";
        return qHttp.postForT(endpoint,GroupFileDirectory.class,"group_id",String.valueOf(group_id));
    }

    /**
     * 获取群子目录文件列表
     * @param group_id 群号
     * @param folder_id 文件夹ID
     * @return 目录文件列表
     */
    public GroupFileDirectory getGroupFilesByFolder(long group_id,String folder_id)
    {
        String endpoint="get_group_files_by_folder";
        return qHttp.postForT(endpoint,GroupFileDirectory.class,"group_id",String.valueOf(group_id),
                "folder_id",folder_id);
    }

    /**
     * 获取群文件资源链接
     * @param group_id 群号
     * @param file_id 文件ID
     * @param busid 文件类型
     * @return 群文件资源链接url
     */
    public String getGroupFileUrl(long group_id, String file_id, String busid)
    {
        String endpoint="get_group_file_url";
        return qHttp.post(endpoint,"group_id",String.valueOf(group_id),
                "file_id",file_id,"busid",busid).get("url");
    }


    /**
     * 下载文件到缓存路径
     * @param url 文件url
     * @param thread_count 线程数
     * @param headers 请求头
     * @return 下载到本地的绝对地址
     */
    public String downloadFile(String url,int thread_count,@Nullable JsonArray headers)
    {
        String endpoint="download_file";
        return qHttp.post(endpoint,"url",url,"thread_count",String.valueOf(thread_count),
                "headers",(headers==null)?null:headers.getAsString()).get("file");
    }



}
