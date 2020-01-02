package top.lover.hyperlink.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lover.hyperlink.dao.TMenuInfoMapper;
import top.lover.hyperlink.entity.TMenuInfo;
import top.lover.hyperlink.service.MenuService;

import java.util.List;
import java.util.Map;

/**
 * @author 山风
 */

@Service
@Transactional
public class MenuInfoServiceImpl extends ServiceImpl<TMenuInfoMapper, TMenuInfo> implements MenuService {

    @Override
    public List<Map<String,Object>> menuList(){
        //获取一级菜单通过角色
        QueryWrapper<TMenuInfo> wrapper = new QueryWrapper<>();
        wrapper.eq(true,"type",1);
        List<Map<String, Object>> first = this.listMaps(wrapper);

        for(Map map1 : first){
            //获取二级菜单
            QueryWrapper<TMenuInfo> wrappers = new QueryWrapper<>();
            wrappers.eq(true,"type",2);
            wrappers.eq(true,"parent_id",map1.get("id"));
            List<Map<String, Object>> second = this.listMaps(wrappers);

            /*for(Map map2 : second){
                String moduletwo = (String) map2.get("moduletwo");
                //获取三级菜单
                List<Map<String, Object>> third = imManService.thirdLevelMenu(rolecode, moduletwo);
                map2.put("third", third);
            }*/
            map1.put("second", second);
        }
        return first;
    }
}

