package top.lover.hyperlink.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.lover.hyperlink.entity.CityInfo;

import java.util.List;

/**
 * @Description 用户业务接口
 * @author 山风
 */
public interface CityService extends IService<CityInfo> {
    public List<CityInfo> getCity();

}
