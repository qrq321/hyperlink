package top.lover.hyperlink.dao;

/**
 * @author 山风
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.lover.hyperlink.entity.UserInfoEntity;

/**
 * @Description 用户信息DAO
 * @Author Sans
 * @CreateTime 2019/6/8 16:24
 */
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {
}

