package top.lover.hyperlink.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import top.lover.hyperlink.entity.TAccountInfo;
import top.lover.hyperlink.util.Encrypt;

import java.util.List;

/**
 * @author shanfeng
 * @create 2020-01-04 16:51
 */
public class BosCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        TAccountInfo user;
        String newPwd = "";
        //向下转型
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        //获取用户页面输入的密码
        String pwd = new String(upToken.getPassword());
        List list = info.getPrincipals().asList();
        if (list.size() == 1){
            user = (TAccountInfo) list.get(0);
            newPwd = Encrypt.md5(pwd, user.getSlat());
        }
        //获取数据库密码
        String dbPwd = info.getCredentials().toString();
        return equals(newPwd, dbPwd);
    }
}
