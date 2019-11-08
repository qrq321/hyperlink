package top.lover.hyperlink.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
* 评论表.
*
* @author 山风
* @date 2019-08-27
*/
@Data
@TableName("T_INFO_REVIEW")//@TableName中的值对应着表名
public class T_INFO_REVIEW{
    @TableId(type = IdType.AUTO)
    private Long N_ID;

    /**
     *产品id.
     */
    private Long PRODUCT_ID;

    /**
    *文章id.
    */
    private Long TITLE_ID;

    /**
    *评论id.
    */
    private Long REVIEW_ID;

    /**
    *评论状态（0-未审核，1-审核通过，2-审核未通过,3-推荐）.
    */
    private Integer REVIEW_STATUS;

    /**
    *用户id.
    */
    private Long USER_ID;

    /**
    *评论内容.
    */
    private String CONTENT;

    /**
    *类型（1-文章，2-评论,3-产品）.
    */
    private Integer TYPE;

    /**
    *用户昵称.
    */
    private String USER_NAME;

    /**
    *不通过原因.
    */
    private String REFUSE_CASE;

    /**
    *审核人.
    */
    private Long AUDITOR;

    /**
    *审核时间.
    */
    private Timestamp AUDIT_TIME;

}