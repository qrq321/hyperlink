package top.lover.hyperlink.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_account_info")
public class TAccountInfo implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "account")
    private String account;

    @TableField(value = "password")
    private String password;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "lastlogin_time")
    private Date lastloginTime;

    @TableField(value = "status")
    private Integer status;

  @TableField(value = "phone")
    private String phone;

    @TableField("email")
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_account_info
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_info
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", userName=").append(userName);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastloginTime=").append(lastloginTime);
        sb.append(", status=").append(status);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}