package top.lover.hyperlink.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.lover.hyperlink.annotation.ResponseResult;
import top.lover.hyperlink.entity.TMenuInfo;
import top.lover.hyperlink.service.MenuService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author 山风
 */
@Slf4j
@RestController
@ResponseResult
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Map<String,Object>> getList() throws Exception{
        List<Map<String,Object>> list = menuService.menuList();
        return list;
    }

    @RequestMapping("/pageList")
    @ResponseBody
    public IPage<TMenuInfo> htt(HttpServletRequest request,@RequestBody String json) throws Exception{

        JSONObject jsonObject = JSONObject.parseObject(json);

        //获取前台发送过来的数据
        Integer pageNo = jsonObject.getInteger("pageNo");
        Integer pageSize = jsonObject.getInteger("pageSize");
        Integer type = jsonObject.getInteger("type");
        Integer parentId = jsonObject.getInteger("parentId");
        IPage<TMenuInfo> page = new Page<>(pageNo, pageSize);
        QueryWrapper<TMenuInfo> wrapper = new QueryWrapper<>();
        TMenuInfo menuInfo = new TMenuInfo();
        menuInfo.setParentId(parentId);
        menuInfo.setType(type);
        //wrapper.setEntity(menuInfo);

        wrapper.eq(true,"type",type);
        wrapper.eq(true,"parent_Id",parentId);
        page = menuService.page(page,wrapper);
        return page;
    }
}
