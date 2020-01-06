package top.lover.hyperlink.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
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

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        System.out.println("shiro 授权管理...");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 根据当前登录用户 查询对应角色和权限
        TAccountInfo user = (TAccountInfo) pc.getPrimaryPrincipal();
        // 调用业务层，查询角色
       /* List<Role> roles = roleService.findByUser(user);
        for (Role role : roles) {
            authorizationInfo.addRole(role.getKeyword());
        }
        // 调用业务层，查询权限
        List<Permission> permissions = permissionService.findByUser(user);
        for (Permission permission : permissions) {
            authorizationInfo.addStringPermission(permission.getKeyword());
        }*/
        return authorizationInfo;
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
        //1 用户信息
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        //2 通过username从数据库中查找 User对象，如果找到，没找到.
        TAccountInfo accountInfo = accountService.getAccountByName(upToken.getUsername());
        if(accountInfo == null||accountInfo.getStatus() != 1){
            //返回null表示账号不存在
            return null;
        }
        AuthenticationInfo info = new SimpleAuthenticationInfo(accountInfo, accountInfo.getPassword(), ByteSource.Util.bytes(accountInfo.getSlat()),getName());
        return info;
    }
}
