package top.lover.hyperlink.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lover.hyperlink.mapper.CityInfoMapper;
import top.lover.hyperlink.entity.CityInfo;
import top.lover.hyperlink.service.CityService;

import java.util.List;

/**
 * @author 山风
 */

@Service
public class CityServiceImpl extends ServiceImpl<CityInfoMapper, CityInfo> implements CityService {

    @Autowired
    private CityInfoMapper cityInfoMapper;

    @Override
    public List<CityInfo> getCity() {
        LambdaQueryWrapper<CityInfo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(CityInfo::getParentId,0);
        List<CityInfo> infos = cityInfoMapper.selectList(wrapper);
        return infos;
    }
}

