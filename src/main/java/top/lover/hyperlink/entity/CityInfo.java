package top.lover.hyperlink.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
* 城市信息表.
*
* @author 山风
* @date 2019-11-5 10点51分
*/
@Data
@TableName("T_CITY_INFO")//@TableName中的值对应着表名
public class CityInfo {
    @TableId(type = IdType.AUTO)
    private Integer ID;
    /**
     * 地区名
     * */
    private String areaName;
    /**
     * 0-省 1-市 2-区
     * */
    private int type;
    /**
     * 父级id
     * */
    private Integer parentId;

}