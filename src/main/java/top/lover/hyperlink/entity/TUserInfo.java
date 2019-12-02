package top.lover.hyperlink.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "t_user_info")
public class TUserInfo implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "account_id")
    private Integer accountId;

   @TableField(value = "real_name")
    private String realName;

   @TableField(value = "phone")
    private String phone;

   @TableField(value = "birthday")
    private Date birthday;

    @TableField(value = "life_limit")
    private Integer lifeLimit;

    @TableField(value = "type")
    private Integer type;

    @TableField(value = "death_type")
    private Integer deathType;

    @TableField(value = "last_id")
    private Integer lastId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user_info
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountId=").append(accountId);
        sb.append(", realName=").append(realName);
        sb.append(", phone=").append(phone);
        sb.append(", birthday=").append(birthday);
        sb.append(", lifeLimit=").append(lifeLimit);
        sb.append(", type=").append(type);
        sb.append(", deathType=").append(deathType);
        sb.append(", lastId=").append(lastId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}