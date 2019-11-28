package top.lover.hyperlink.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.push.model.v20160801.PushRequest;
import com.aliyuncs.push.model.v20160801.PushResponse;
import com.aliyuncs.utils.ParameterHelper;
import com.aliyuncs.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author qinrq
 */
@Slf4j
@Component
public class AliPushUtil {
    /**
     * 阿里推送accessKeyId.
     */
    private String accessKeyId = "LTAI4FcRTZ52QccCaHHRbf3T";

    /**
     * accessKeySecret.
     */
    private String accessKeySecret = "2kQnWA8i3MZuyFk26aQiU4ctg3Gzgr";

    /**
     * map 推送参数.
     *
     * @param map map的参数如下
     * appKey eg：28105286l 27918662l//appkey 阿里云配置的数据
     * target 默认：ALL 推送目标 DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
     * value 默认: ALL //根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
     * deviceType 默认: ANDROID //设备类型 ANDROID iOS ALL.
     * title // 消息的标题
     * content // 消息的内容
     * @throws ClientException 客户端异常
     * */
    public void pushNotice(Map<String,String> map) throws ClientException {

        String appKey = map.get("appKey");
        String target = StringUtils.isEmpty(map.get("target"))?"ALL":map.get("target");
        String value = StringUtils.isEmpty(map.get("value"))?"ALL":map.get("value");
        String deviceType = StringUtils.isEmpty(map.get("deviceType"))?"ANDROID":map.get("deviceType");
        String title = map.get("title");
        String content = map.get("content");
        if (StringUtils.isEmpty(appKey)||StringUtils.isEmpty(title)||StringUtils.isEmpty(content)) {
            return;
        }
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        PushRequest pushRequest = new PushRequest();

        pushRequest.setAppKey(Long.valueOf(appKey));
        pushRequest.setTarget(target); //推送目标: DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
        pushRequest.setTargetValue(value); //根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
        pushRequest.setDeviceType(deviceType); // 设备类型 ANDROID iOS ALL.
        // 推送配置
        pushRequest.setTitle(title); // 消息的标题
        pushRequest.setBody(content); // 消息的内容
        if("iOS".equals(deviceType)){
            putIosPushMsg(pushRequest);
        }else{
            // 设置辅助弹窗打开Activity
            pushRequest.setAndroidPopupActivity("com.houhan.flowsun.activitys.AliPushPopActivity");
            // 设置辅助弹窗通知标题
            pushRequest.setAndroidPopupTitle(title);
            // 设置辅助弹窗通知内容
            pushRequest.setAndroidPopupBody(content);
            putAndroidPushMsg(pushRequest);
        }
        // 推送控制
        Date pushDate = new Date(System.currentTimeMillis()) ; // 30秒之间的时间点, 也可以设置成你指定固定时间
        String pushTime = ParameterHelper.getISO8601Time(pushDate);
        pushRequest.setPushTime(pushTime); // 延后推送。可选，如果不设置表示立即推送
        String expireTime = ParameterHelper.getISO8601Time(new Date(System.currentTimeMillis() + 12 * 3600 * 1000)); // 12小时后消息失效, 不会再发送
        pushRequest.setExpireTime(expireTime);
        pushRequest.setStoreOffline(true); // 离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到
        PushResponse pushResponse = client.getAcsResponse(pushRequest);
        log.info("RequestId: "+pushResponse.getRequestId()+", MessageID: "+pushResponse.getMessageId()+"\n");
    }

    /**
     * 组装iOS的推送配置.
     * @param  pushRequest iOS推送配置
     * */
    private void putIosPushMsg(PushRequest pushRequest){
        // 推送配置: iOS
        //消息条数自增
        pushRequest.setIOSBadgeAutoIncrement(true);
        pushRequest.setPushType("NOTICE"); // 消息类型 MESSAGE NOTICE
        // iOS通知声音
        pushRequest.setIOSMusic("default");
        //iOS10通知副标题的内容
        pushRequest.setIOSSubtitle("点击通知打开APP查看详情");
        //指定iOS10通知Category
        pushRequest.setIOSNotificationCategory("iOS10 Notification Category");
        //是否允许扩展iOS通知内容
        pushRequest.setIOSMutableContent(true);
        //iOS的通知是通过APNs中心来发送的，需要填写对应的环境信息。"DEV" : 表示开发环境 "PRODUCT" : 表示生产环境
        pushRequest.setIOSApnsEnv("DEV");
        // 消息推送时设备不在线（既与移动推送的服务端的长连接通道不通），则这条推送会做为通知，通过苹果的APNs通道送达一次。注意：离线消息转通知仅适用于生产环境
        pushRequest.setIOSRemind(true);
        //iOS消息转通知时使用的iOS通知内容，仅当iOSApnsEnv=PRODUCT && iOSRemind为true时有效
        pushRequest.setIOSRemindBody("iOSRemindBody");
        //通知的扩展属性(注意 : 该参数要以json map的格式传入,否则会解析出错)
        pushRequest.setIOSExtParameters("{\"k1\":\"ios\",\"k2\":\"v2\"}");
    }
    /**
     * 组装ANDROID的推送配置.
     * @param  pushRequest ANDROID推送配置
     * */
    private void putAndroidPushMsg(PushRequest pushRequest){
        // 推送配置: Android
        pushRequest.setPushType("NOTICE"); // 消息类型 MESSAGE NOTICE
        pushRequest.setAndroidNotifyType("BOTH");//通知的提醒方式 "VIBRATE" : 震动 "SOUND" : 声音 "BOTH" : 声音和震动 NONE : 静音
        pushRequest.setAndroidNotificationBarType(1);//通知栏自定义样式0-100
        pushRequest.setAndroidNotificationBarPriority(1);//通知栏自定义样式0-100
        pushRequest.setAndroidOpenType("NONE"); //点击通知后动作 "APPLICATION" : 打开应用 "ACTIVITY" : 打开AndroidActivity "URL" : 打开URL "NONE" : 无跳转
        pushRequest.setAndroidMusic("default"); // Android通知音乐
        pushRequest.setAndroidExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}"); //设定通知的扩展属性。(注意 : 该参数要以 json map 的格式传入,否则会解析出错)
    }
}
