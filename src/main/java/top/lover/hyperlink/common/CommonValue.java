package top.lover.hyperlink.common;

import lombok.Builder;
import lombok.Data;

/**
 * @author 山风
 */
@Data
@Builder
public class CommonValue {
    /**
     * 类型
     */
    Integer code;
    /**
     * 详情
     */
    String msg;
    /**
     * 详情
     */
    String param;
}
