package top.lover.hyperlink.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.lover.hyperlink.entity.UserInfoEntity;

import java.util.ArrayList;

/**
 * @Description 用户业务接口
 * @author qinrq
 */
public interface UserInfoService extends IService<UserInfoEntity> {
    public ArrayList<UserInfoEntity> getUserInfo();

}
