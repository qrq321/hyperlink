package top.lover.hyperlink.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.lover.hyperlink.entity.TAccountInfo;

public interface AccountService extends IService<TAccountInfo> {
    /**
     * 通过名称获取账号
     * */
    public TAccountInfo getAccountByName(String name);
}

