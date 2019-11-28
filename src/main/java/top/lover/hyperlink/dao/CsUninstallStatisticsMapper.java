package top.lover.hyperlink.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.lover.hyperlink.entity.CsUninstallStatistics;

import java.util.List;

@Mapper
public interface CsUninstallStatisticsMapper extends BaseMapper<CsUninstallStatistics> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_uninstall_statistics
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long nId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_uninstall_statistics
     *
     * @mbggenerated
     */
    int insert(CsUninstallStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_uninstall_statistics
     *
     * @mbggenerated
     */
    CsUninstallStatistics selectByPrimaryKey(Long nId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_uninstall_statistics
     *
     * @mbggenerated
     */
    List<CsUninstallStatistics> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_uninstall_statistics
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CsUninstallStatistics record);
}