package top.lover.hyperlink.controller;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lover.hyperlink.common.CommonValue;
import top.lover.hyperlink.entity.UserInfoEntity;
import top.lover.hyperlink.service.UserInfoService;

/**
 * @author qinrq
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserInfoService userInfoService;
    /**
     * 根据ID获取用户信息
     * @Param  userId  用户ID
     * @Return UserInfoEntity 用户实体
     */
    @CrossOrigin(origins = "*")
    @RequestMapping("/index")
    @ResponseBody
    public CommonValue insert(String param){
        System.out.println("传入的参数:"+param);
        System.out.println("\uD83D\uDE04");
        UserInfoEntity user = new UserInfoEntity();
        user.setName("😄🙂🌁");
        user.setAge(18);
        userInfoService.save(user);
        String code = "返回码！！！！";
        CommonValue commonValue = new CommonValue();
        commonValue.setCode(-1);
        commonValue.setMsg("请求失败，请联系后台开发人员确认！！！");
        return commonValue;
    }
    @RequestMapping("/readhtml")
    @ResponseBody
    public String readhtml(String url) throws Exception{

        Connection conn = Jsoup.connect(url);
        conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        conn.header("Accept-Encoding", "gzip, deflate, sdch");
        conn.header("Accept-Language", "zh-CN,zh;q=0.8");
        conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        Document doc = conn.get();

        return "哈哈";
    }
}
