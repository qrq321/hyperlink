package top.lover.hyperlink.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lover.hyperlink.dao.UserInfoDao;
import top.lover.hyperlink.entity.UserInfoEntity;
import top.lover.hyperlink.service.UserInfoService;

import java.util.ArrayList;

/**
 * @author 山风
 */

@Service
@Transactional
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {

    @Override
    public ArrayList<UserInfoEntity> getUserInfo() {

        return null;
    }

}

