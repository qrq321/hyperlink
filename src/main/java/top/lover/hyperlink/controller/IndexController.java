package top.lover.hyperlink.controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.lover.hyperlink.common.CommonValue;
import top.lover.hyperlink.service.UserInfoService;

/**
 * @author 山风
 */
@Controller
@Api(value = "测试swagger2",tags = "用户登陆相关Api")
@RequestMapping("/index")
@AllArgsConstructor
public class IndexController {

    private UserInfoService userInfoService;

    /**
     * 根据ID获取用户信息
     * @Param  userId  用户ID
     * @Return UserInfoEntity 用户实体
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/getValue/{param}")
    @ResponseBody
    public CommonValue getValue(@PathVariable String param){
        //Field injection is not recommended
        System.out.println("传入的参数:"+param);
        System.out.println("\uD83D\uDE04");
        String code = "返回码！！！！";
        CommonValue commonValue = CommonValue.builder().code(-1).msg("请求失败，请联系后台开发人员确认！！！").param(param).build();
        return commonValue;
    }
}
