package top.lover.hyperlink.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.lover.hyperlink.entity.CsDefaultTouchRate;

@Mapper
public interface CsDefaultTouchRateMapper extends BaseMapper<CsDefaultTouchRate> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_default_touch_rate
     *
     * @mbggenerated
     */
    List<CsDefaultTouchRate> selectAll();
}