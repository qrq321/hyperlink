package top.lover.hyperlink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lover.hyperlink.common.CommonValue;
import top.lover.hyperlink.entity.CityInfo;
import top.lover.hyperlink.entity.UserInfoEntity;
import top.lover.hyperlink.service.CityService;
import top.lover.hyperlink.service.UserInfoService;

import java.util.List;

/**
 * @author 山风
 */
@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;
    /**
     * 根据ID获取用户信息
     * @Param  userId  用户ID
     * @Return UserInfoEntity 用户实体
     */
    @RequestMapping("/getCity")
    @ResponseBody
    public List<CityInfo> getCity(String param){
        List<CityInfo> city = cityService.getCity();
        city.forEach(e-> System.out.println(e.toString()));
        return city;
    }
}
