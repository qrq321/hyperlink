package top.lover.hyperlink.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lover.hyperlink.annotation.ResponseResult;
import top.lover.hyperlink.common.CommonValue;
import top.lover.hyperlink.entity.TAccountInfo;
import top.lover.hyperlink.service.AccountService;

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
    public IPage<TAccountInfo> htt(@RequestBody CommonValue common) throws Exception{
        //获取前台发送过来的数据
//        Integer type = jsonObject.getInteger("type");
//        Integer parentId = jsonObject.getInteger("parentId");
        IPage<TAccountInfo> page = new Page<>(common.getPageNum(), common.getPageSize());
        QueryWrapper<TAccountInfo> wrapper = new QueryWrapper<>();
//        wrapper.eq(true,"type",type);
//        wrapper.eq(true,"parent_Id",parentId);
        page = accountService.page(page,wrapper);
        return page;
    }
}
