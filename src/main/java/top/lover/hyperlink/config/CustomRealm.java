package top.lover.hyperlink.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import top.lover.hyperlink.entity.TAccountInfo;
import top.lover.hyperlink.service.AccountService;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shanfeng
 * @create 2019-12-27 11:36
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private AccountService accountService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("user:show");
        stringSet.add("user:admin");
        info.setStringPermissions(stringSet);
        return info;
    }

    /**
     * 这里可以注入userService,为了方便演示，我就写死了帐号了密码
     * private UserService userService;
     * <p>
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        // token是用户输入的用户名和密码
        // 第一步从token中取出用户名
        String account = (String) token.getPrincipal();
        // 第二步：根据用户输入的userCode从数据库查询
        System.out.println(account);

        QueryWrapper<TAccountInfo> wrapper = new QueryWrapper<>();
        wrapper.eq(true,"account",account);
        TAccountInfo accountInfo = accountService.getOne(wrapper);
        String userPwd = new String((char[]) token.getCredentials());
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(accountInfo.getAccount(),accountInfo.getPassword(),"credentialsSalt", getName());
        //根据用户名从数据库获取密码
        String password = accountInfo.getPassword();
        if (account == null) {
            throw new AccountException("用户名不正确");
        } else if (!userPwd.equals(password )) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(account, password,getName());
    }
}
