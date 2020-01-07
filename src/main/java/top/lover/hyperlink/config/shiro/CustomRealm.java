package top.lover.hyperlink.config.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import top.lover.hyperlink.entity.TAccountInfo;
import top.lover.hyperlink.service.AccountService;

/**
 * @author shanfeng
 * @create 2019-12-27 11:36
 */

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private AccountService accountService;

    /**
     * 角色授权*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        System.out.println("执行资源授权");
        Subject subject = SecurityUtils.getSubject();
        TAccountInfo user = (TAccountInfo) pc.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if("zhang".equals(user.getAccount())){
            info.addStringPermission("userslist");
            info.addStringPermission("/user:list");
        }
        // 根据当前登录用户 查询对应角色和权限
        // 调用业务层，查询角色
       /* List<Role> roles = roleService.findByUser(user);
        for (Role role : roles) {
            info.addRole(role.getKeyword());
        }
        // 调用业务层，查询权限
        List<Permission> permissions = permissionService.findByUser(user);
        for (Permission permission : permissions) {
            info.addStringPermission(permission.getKeyword());
        }*/
        return info;
    }

    /**
     * private UserService userService;
     * <p>
     * 执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        //1 用户信息
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        //2 通过username从数据库中查找 User对象，如果找到，没找到.
        TAccountInfo accountInfo = accountService.getAccountByName(upToken.getUsername());
        if(accountInfo == null||accountInfo.getStatus() != 1){
            //返回null表示账号不存在
            return null;
        }
        return new SimpleAuthenticationInfo(accountInfo, accountInfo.getPassword(), ByteSource.Util.bytes(accountInfo.getSlat()),getName());
    }
}
