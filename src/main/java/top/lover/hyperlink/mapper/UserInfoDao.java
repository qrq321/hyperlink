package top.lover.hyperlink.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.lover.hyperlink.entity.UserInfoEntity;

/**
 * @Description 用户信息DAO
 * @author 山风
 * @CreateTime 2019/6/8 16:24
 */
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {
}

