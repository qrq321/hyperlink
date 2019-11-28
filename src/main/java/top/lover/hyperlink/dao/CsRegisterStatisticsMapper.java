package top.lover.hyperlink.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.lover.hyperlink.entity.CsRegisterStatistics;

import java.util.List;

@Mapper
public interface CsRegisterStatisticsMapper extends BaseMapper<CsRegisterStatistics> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_register_statistics
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long nId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_register_statistics
     *
     * @mbggenerated
     */
    int insert(CsRegisterStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_register_statistics
     *
     * @mbggenerated
     */
    CsRegisterStatistics selectByPrimaryKey(Long nId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_register_statistics
     *
     * @mbggenerated
     */
    List<CsRegisterStatistics> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_register_statistics
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CsRegisterStatistics record);
}