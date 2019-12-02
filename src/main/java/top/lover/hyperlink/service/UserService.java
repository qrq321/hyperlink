package top.lover.hyperlink.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.lover.hyperlink.entity.TUserInfo;

import java.util.ArrayList;

/**
 * @Description 用户业务接口
 * @author 山风
 */
public interface UserService extends IService<TUserInfo> {
    public ArrayList<TUserInfo> getUserInfo();

}
