package top.lover.hyperlink.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lover.hyperlink.dao.CityInfoDao;
import top.lover.hyperlink.entity.CityInfo;
import top.lover.hyperlink.service.CityService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 山风
 */

@Service
public class CityServiceImpl extends ServiceImpl<CityInfoDao, CityInfo> implements CityService {

    @Resource
    private CityInfoDao cityInfoDao;

    @Override
    public List<CityInfo> getCity() {
        LambdaQueryWrapper<CityInfo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(CityInfo::getParentId,0);
        List<CityInfo> infos = cityInfoDao.selectList(wrapper);
        return infos;
    }
}

