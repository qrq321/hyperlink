package top.lover.hyperlink.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lover.hyperlink.dao.TMenuInfoMapper;
import top.lover.hyperlink.entity.TMenuInfo;
import top.lover.hyperlink.service.MenuService;

import java.util.HashMap;

/**
 * @author 山风
 */

@Service
@Transactional
public class MenuInfoServiceImpl extends ServiceImpl<TMenuInfoMapper, TMenuInfo> implements MenuService {

}

