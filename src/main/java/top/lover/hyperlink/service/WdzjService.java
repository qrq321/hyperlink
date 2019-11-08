package top.lover.hyperlink.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jsoup.nodes.Document;
import top.lover.hyperlink.entity.T_INFO_TITLE;

import java.util.ArrayList;

/**
 * @Description 用户业务接口
 * @author qinrq
 */
public interface WdzjService extends IService<T_INFO_TITLE> {
    /**
     * 处理网贷之家的网页.
     * */
    public boolean dealDoc(Document doc);

}
