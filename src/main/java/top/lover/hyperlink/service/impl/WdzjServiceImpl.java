package top.lover.hyperlink.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lover.hyperlink.dao.InfoTitleDao;
import top.lover.hyperlink.entity.T_INFO_TITLE;
import top.lover.hyperlink.service.WdzjService;

import java.util.ArrayList;

/**
 * @author qinrq
 */

@Service
@Transactional
public class WdzjServiceImpl extends ServiceImpl<InfoTitleDao, T_INFO_TITLE> implements WdzjService {


    @Override
    public boolean dealDoc(Document doc) {
        return false;
    }
}

