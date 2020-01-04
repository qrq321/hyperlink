package top.lover.hyperlink.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import top.lover.hyperlink.util.Encrypt;

/**
 * @author shanfeng
 * @create 2020-01-04 16:51
 */
public class BosCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //向下转型
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        //获取用户页面输入的密码
        String pwd = new String(upToken.getPassword());
        //加密
        String newPwd = Encrypt.md5(pwd, upToken.getCredentials().toString());
        //获取数据库密码
        String dbPwd = info.getCredentials().toString();
        return equals(newPwd, dbPwd);
    }
}
