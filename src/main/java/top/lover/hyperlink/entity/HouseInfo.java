package top.lover.hyperlink.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
* 房屋信息表.
*
* @author 山风
* @date 2019-11-5 10点51分
*/
@Data
@TableName("T_HOUST_INFO")//@TableName中的值对应着表名
public class HouseInfo {
    @TableId(type = IdType.AUTO)
    private Long ID;
    /**图片地址.*/
    private String imgUrl;
    /**/
}