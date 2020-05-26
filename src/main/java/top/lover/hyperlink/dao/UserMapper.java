package top.lover.hyperlink.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.lover.hyperlink.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}