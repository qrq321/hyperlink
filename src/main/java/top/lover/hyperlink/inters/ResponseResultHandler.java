package top.lover.hyperlink.inters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.lover.hyperlink.annotation.ResponseResult;
import top.lover.hyperlink.common.Result;
import top.lover.hyperlink.enumtype.ResultCode;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;

/**
 * @author qinrq
 */
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    //标记名称
    public  static final String RESPONSE_RESULT_ANN = "RESPONSE-RESULT-ANN";

    //是否请求 包含了 包装注解 标记，没有就直接返回，不需要重写返回体
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes sra = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        HttpServletRequest request = sra.getRequest();
        //判断请求，是否有包装标记
        ResponseResult responseResult = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANN);
        return responseResult == null ? false : true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        log.info("返回之前的数据:"+body.toString());
        //报错处理
        if(body instanceof LinkedHashMap){
            LinkedHashMap<String,Object> map = (LinkedHashMap<String,Object>) body;
            Result result = Result.failure(ResultCode.FAILSE,body);
            result.setCode(Integer.parseInt(map.get("status").toString()));
            result.setMsg(map.get("message").toString());
            return result;
        }
        if(body instanceof Result){
            return body;
        }
        //返回错误数据的处理
        return Result.success(body);
    }



}
