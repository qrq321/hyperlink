package top.lover.hyperlink.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.lover.hyperlink.annotation.ResponseResult;
import top.lover.hyperlink.entity.CityInfo;
import top.lover.hyperlink.service.CityService;
import top.lover.hyperlink.util.AliPushUtil;
import top.lover.hyperlink.util.FileUtil;
import top.lover.hyperlink.util.HttpUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 山风
 */
@Slf4j
@RestController
@ResponseResult
@Api(value = "testController",tags = "我是项目说明。。。。。。。")
@RequestMapping("/test")
public class CityController {
    @Value("${appid}")
    public String appId;

    @Value("${secret}")
    public String secret;
    int nums = 1;
    /**
     * sevice
     * */
    @Autowired
    private CityService cityService;
    /**
     * 阿里推送
     * */
    @Autowired
    private AliPushUtil aliPushUtil;
    /**
     * 根据ID获取用户信息
     * @Param  userId  用户ID
     * @Return UserInfoEntity 用户实体
     */
    @RequestMapping("/getCity")
    @ApiOperation(value = "我也是测试接口的定义数据的")
    @ResponseBody
    public List<CityInfo> getCity(@ApiParam(value = "尽职报告id", required = true) @RequestParam String obj){
        System.out.println(obj);
        List<CityInfo> city = cityService.getCity();
        CityInfo cityInfo = new CityInfo();
        cityInfo.setAreaName("name");
        cityInfo.setParentId(1);
        cityInfo.setType(1);
        cityService.save(cityInfo);
        city.forEach(e-> System.out.println(e.toString()));
        return city;
    }
    /**
     * 根据ID获取用户信息
     * @Param  userId  用户ID
     * @Return UserInfoEntity 用户实体
     */
    @RequestMapping("/getCity1")
    @ResponseBody
    public List<CityInfo> getCity1( JSONObject obj){
        List<CityInfo> city = cityService.getCity();
        city.forEach(e-> System.out.println(e.toString()));
        return city;
    }

    @RequestMapping("/test")
    @ResponseBody
    public void htt(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Enumeration pNames = request.getParameterNames();
        while (pNames.hasMoreElements()) {
            String name = (String) pNames.nextElement();
            String value = request.getParameter(name);
            // out.print(name + "=" + value);

            String log = "name =" + name + "     value =" + value;
        }

        String signature = request.getParameter("signature");/// 微信加密签名
        String timestamp = request.getParameter("timestamp");/// 时间戳
        String nonce = request.getParameter("nonce"); /// 随机数
        String echostr = request.getParameter("echostr"); // 随机字符串
        PrintWriter out = response.getWriter();

        //if (SignUtil.checkSignature(signature, timestamp, nonce)) {
        out.print(echostr);
//		}s
        out.close();
    }

    @RequestMapping("/addTitle")
    @ResponseBody
    public String addTitle(String token){
        JSONObject jsonObject = new JSONObject();
        String str = FileUtil.readFromTextFile("D:\\upload\\tree.txt");
        jsonObject.parse(str);
        String utl ="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+token;
        String s = HttpUtil.sendPost(utl, str);
        System.out.println("s"+s);
        JSONObject parse = JSONObject.parseObject(s);
        String res = parse.getInteger("errcode")==0?"success":s;
        return res;
    }
    @RequestMapping("/getToken")
    @ResponseBody
    public String getAccessToken(){
        String s = HttpUtil.sendGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appId+"&secret="+secret+"");
        System.out.println("access_token:"+s);
        return s;
    }

    @RequestMapping("/test1")
    @ResponseBody
    public String AliPush(@RequestBody JSONObject obj) throws Exception{
        System.out.println(obj.toString());
        if(StringUtils.isEmpty(obj.getString("param"))){
           return "false";
        }
        Map<String,String> map = new HashMap<String, String>();
         /* appKey eg：28105286l 27918662l//appkey 阿里云配置的数据
                * target 默认：ALL 推送目标 DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
                * value 默认: ALL //根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
                * deviceType 默认: ANDROID //设备类型 ANDROID iOS ALL.
                * title // 消息的标题
                * content // 消息的内容*/
         //ios
//        map.put("appKey","27918662");
        //android
        //map.put("appKey","28105286");
        map.put("appKey","28139772");
        map.put("target","DEVICE");
//        map.put("value","58a0a4beef2e4accbe66f5d4782b785b");
        //android
        map.put("value",obj.getString("param"));
        map.put("deviceType","ANDROID");
        map.put("title","title");
        map.put("content","欢迎优雅聪明的你，使用本app");
        aliPushUtil.pushNotice(map);
        return "success";
    }
    @RequestMapping("/com1")
    @ResponseBody
    public String Testt(@RequestBody JSONObject obj) throws Exception{
        System.out.println("请求的次数："+nums);
        nums++;
        HashMap<String,String> map = (HashMap<String,String>) obj.get("map");
        log.info("第三:"+map.get("deviceType"));
        log.info("第三:"+map.get("value"));
        log.info("第三:"+map.get("content"));
        log.info("第三:"+map.get("target"));
        return "success";
    }
    @RequestMapping("/com2")
    @ResponseBody
    public String Testt1(@RequestBody JSONObject obj) throws Exception{
        HashMap<String,String> map = (HashMap<String,String>) obj.get("map");
        log.info("第二:"+map.get("deviceType"));
        log.info("第二:"+map.get("value"));
        log.info("第二:"+map.get("content"));
        log.info("第二:"+map.get("target"));
        return "success";
    }
    @RequestMapping("/com3")
    @ResponseBody
    public String Testt3(@RequestBody JSONObject obj) throws Exception{
        HashMap<String,String> map = (HashMap<String,String>) obj.get("map");
        log.info("第三:"+map.get("deviceType"));
        log.info("第三:"+map.get("value"));
        log.info("第三:"+map.get("content"));
        log.info("第三:"+map.get("target"));
        return "success";
    }
}