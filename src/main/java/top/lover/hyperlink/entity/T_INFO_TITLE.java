package top.lover.hyperlink.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
* 文章资讯表.
*
* @author 山风
* @date 2019-08-27
*/
@Data
@TableName("T_INFO_TITLE")//@TableName中的值对应着表名
public class T_INFO_TITLE{
    @TableId(type = IdType.AUTO)
    private Long N_ID;

    /**
     *是否推荐.
     */
    private Integer IS_RECOMMEND;

    /**
    *标题.
    */
    private String TITLE;

    /**
    *副标题.
    */
    private String SUBTITLE;

    /**
    *关键词.
    */
    private String KEY_WORDS;
    /**
    *描述.
    */
    private String DESCRIPT;
    /**
    *图片（视频链接）.
    */
    private String IMAGE;
    /**
    *缩略图.
    */
    private String THUMBNAIL;
    /**
    *内容.
    */
    private String CONTENT;

    /**
    *来源.
    */
    private String RESOURCES;

    /**
    *推荐标签.
    */
    private String REC_TAGS;

    /**
    *发布时间.
    */
    private Timestamp RELEASE_TIME;

    /**
    *审核状态.
    */
    private Integer INI_STATUS;

    /**
    *文章类型（1-图文，2-视频）.
    */
    private Integer CON_TYPE;
    /**
     *不通过原因.
     */
    private String REFUSE_CASE;
    /**
     *时长.
     */
    private String DURATION;
    /**
     *审核人.
     */
    private Long AUDITOR;

    /**
     *审核时间.
     */
    private Timestamp AUDIT_TIME;

    /**
     *是否是后台添加（添加）.
     */
    private Integer IS_MANAGE;
}