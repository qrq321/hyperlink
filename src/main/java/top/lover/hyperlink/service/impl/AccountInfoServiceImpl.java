package top.lover.hyperlink.service.impl;

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

}

