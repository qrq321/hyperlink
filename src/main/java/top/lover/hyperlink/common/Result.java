package top.lover.hyperlink.common;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import top.lover.hyperlink.enumtype.ResultCode;

import java.io.Serializable;

/**
 * @author qinrq
 */
@Slf4j
@Data
public class Result implements Serializable {
    /**
     * 返回状态码
     * */
    private Integer code;
    /**
     * 返回信息描述
     * */
    private String msg;
    /**
     * 返回的数据
     * */
    private Object datas;
    Result(){
    }
    public Result(ResultCode resultCode,Object datas){
        this.code = resultCode.code();
        this.msg = resultCode.msg();
        this.datas = datas;
    }
    //返回成功
    public static Result success(){
        Result result = new Result();
        result.setResult(ResultCode.SUCCESS);
        return result;
    }
    //返回成功
    public static Result success(Object datas){
        Result result = new Result();
        result.setResult(ResultCode.SUCCESS);
        result.setDatas(datas);
        return result;
    }
    //返回失败
    public static Result failure(ResultCode resultCode){
        Result result = new Result();
        result.setResult(resultCode);
        return result;
    }
    //返回失败
    public static Result failure(ResultCode resultCode,Object datas){
        Result result = new Result();
        result.setResult(ResultCode.FAILSE);
        result.setDatas(datas);
        return result;
    }

    public void setResult(ResultCode result){
        this.code = result.code();
        this.msg = result.msg();
    }

}
