package top.lover.hyperlink.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lover.hyperlink.dao.TUserInfoMapper;
import top.lover.hyperlink.entity.TUserInfo;
import top.lover.hyperlink.service.UserService;

import java.util.ArrayList;

/**
 * @author 山风
 */

@Service
@Transactional
public class UserInfoServiceImpl extends ServiceImpl<TUserInfoMapper, TUserInfo> implements UserService {

    @Override
    public ArrayList<TUserInfo> getUserInfo() {

        return null;
    }

}

