package top.lover.hyperlink.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jsoup.nodes.Document;

/**
 * @Description 用户业务接口
 * @author 山风
 */
public interface WdzjService extends IService<T_INFO_TITLE> {
    /**
     * 处理网贷之家的网页.
     * */
    public boolean dealDoc(Document doc);

}
