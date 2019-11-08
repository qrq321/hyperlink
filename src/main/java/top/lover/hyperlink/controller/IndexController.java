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
 * @author 山风
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
}
