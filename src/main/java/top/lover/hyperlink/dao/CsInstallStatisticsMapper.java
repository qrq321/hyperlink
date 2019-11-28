package top.lover.hyperlink.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.lover.hyperlink.entity.CsInstallStatistics;

@Mapper
public interface CsInstallStatisticsMapper extends BaseMapper<CsInstallStatistics> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_install_statistics
     *
     * @mbggenerated
     */
    int insert(CsInstallStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_install_statistics
     *
     * @mbggenerated
     */
    List<CsInstallStatistics> selectAll();
}