package top.lover.hyperlink.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lover.hyperlink.annotation.ResponseResult;
import top.lover.hyperlink.common.CommonValue;
import top.lover.hyperlink.common.Result;
import top.lover.hyperlink.entity.TAccountInfo;
import top.lover.hyperlink.enumtype.ResultCode;
import top.lover.hyperlink.service.AccountService;
import top.lover.hyperlink.util.Encrypt;

import java.util.Date;
import java.util.Random;

/**
 * @author 山风
 */
@Controller
@ResponseResult
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/list")
    @ResponseBody
    public IPage<TAccountInfo> list(@RequestBody CommonValue common) throws Exception{
        //获取前台发送过来的数据
//        Integer type = jsonObject.getInteger("type");
//        Integer parentId = jsonObject.getInteger("parentId");
        IPage<TAccountInfo> page = new Page<>(common.getPageNum(), common.getPageSize());
        QueryWrapper<TAccountInfo> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(common.getQuery())){
            wrapper.like(true,"account",common.getQuery());
        }
//        wrapper.eq(true,"parent_Id",parentId);
        page = accountService.page(page,wrapper);
        return page;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody TAccountInfo accountInfo) throws Exception{
        Result result = Result.success();
        if(accountInfo.getId() == null){
            //添加用户
            QueryWrapper<TAccountInfo> wrapper = new QueryWrapper<>();
            wrapper.eq(true,"account",accountInfo.getAccount());
            TAccountInfo one = accountService.getOne(wrapper);
            if(one != null){
                return Result.failure(ResultCode.FAILSE,"账号已存在，请重新输入账号！！！");
            }
            accountInfo.setCreateTime(new Date());
            accountInfo.setStatus(1);
            String slat = new Random().nextInt(99)+"";
            accountInfo.setPassword(Encrypt.md5(accountInfo.getPassword(),slat));
            accountInfo.setSlat(slat);
            if(!accountService.save(accountInfo)){
                result = Result.failure(ResultCode.FAILSE);
            }
        }else{
            //修改用户
            QueryWrapper<TAccountInfo> wrapper = new QueryWrapper<>();
            wrapper.eq(true,"id",accountInfo.getId());
            accountInfo.setLastloginTime(new Date());
            TAccountInfo one = accountService.getOne(wrapper);
            String password = Encrypt.md5(accountInfo.getPassword(),one.getSlat());
            BeanUtils.copyProperties(accountInfo,one);
            if(!one.getPassword().equals(password)){
                String slat = new Random().nextInt(99)+"";
                one.setPassword(Encrypt.md5(one.getPassword(),slat));
                one.setSlat(slat);
            }
            if(!accountService.updateById(one)){
                result = Result.failure(ResultCode.FAILSE);
            }
        }
        return result;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TAccountInfo findByid(@PathVariable Integer id) throws Exception{
        QueryWrapper<TAccountInfo> wrapper = new QueryWrapper<>();
        wrapper.eq(true,"id",id);
        TAccountInfo one = accountService.getOne(wrapper);
        return one;
    }
}
