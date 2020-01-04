package top.lover.hyperlink.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lover.hyperlink.dao.TAccountInfoMapper;
import top.lover.hyperlink.entity.TAccountInfo;
import top.lover.hyperlink.service.AccountService;

/**
 * @author 山风
 */

@Service
@Transactional
public class AccountInfoServiceImpl extends ServiceImpl<TAccountInfoMapper, TAccountInfo> implements AccountService {

    @Override
    public TAccountInfo getAccountByName(String name) {
        //2 通过username从数据库中查找 User对象，如果找到，没找到.
        QueryWrapper<TAccountInfo> wrapper = new QueryWrapper<>();
        //        wrapper.eq(true,"account",account);
        wrapper.eq(true,"account",name);
        TAccountInfo accountInfo = this.getOne(wrapper);
        return accountInfo;
    }
}

