package top.lover.hyperlink.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lover.hyperlink.annotation.ResponseResult;
import top.lover.hyperlink.common.Result;
import top.lover.hyperlink.enumtype.ResultCode;

/**
 * @author 山风
 */
@Controller
@ResponseResult
@RequestMapping("")
public class LoginController {


   /* @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String defaultLogin(UserLogin login) {
        System.out.println(login.getUsername());
        return "首页";
    }*/


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody UserLogin login) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(login.getUsername(), login.getPassword());
        token.setRememberMe(true);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return Result.failure(ResultCode.FAILSE,"未知账户");
        } catch (IncorrectCredentialsException ice) {
            return Result.failure(ResultCode.FAILSE,"密码不正确");
        } catch (LockedAccountException lae) {
            return Result.failure(ResultCode.FAILSE,"账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            return Result.failure(ResultCode.FAILSE,"用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            return Result.failure(ResultCode.FAILSE,"用户名或密码不正确");
        }
        if (subject.isAuthenticated()) {
            return Result.success("登录成功");
        } else {
            token.clear();
            return Result.failure(ResultCode.FAILSE,"登录失败");
        }
    }
}
