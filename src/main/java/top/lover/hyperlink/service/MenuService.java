package top.lover.hyperlink.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.lover.hyperlink.entity.TMenuInfo;

import java.util.List;
import java.util.Map;

public interface MenuService extends IService<TMenuInfo> {

    /**
     * 获取菜单列表
     * */
    public List<Map<String,Object>> menuList();
}

