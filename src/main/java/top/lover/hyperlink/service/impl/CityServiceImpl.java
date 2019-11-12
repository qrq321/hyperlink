package top.lover.hyperlink.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lover.hyperlink.dao.CityInfoDao;
import top.lover.hyperlink.entity.CityInfo;
import top.lover.hyperlink.service.CityService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 山风
 */

@Service
@Transactional
public class CityServiceImpl extends ServiceImpl<CityInfoDao, CityInfo> implements CityService {

    @Resource
    private CityInfoDao cityInfoDao;

    @Override
    public List<CityInfo> getCity() {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("parent_id",0);
        List<CityInfo> infos = cityInfoDao.selectByMap(map);
        return infos;
    }
}

