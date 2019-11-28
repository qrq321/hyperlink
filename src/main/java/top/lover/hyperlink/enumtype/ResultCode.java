package top.lover.hyperlink.enumtype;

public enum ResultCode {
    /**
     * accessKeyId.
     */
    SUCCESS(1,"成功"),
    /**
     * accessKeySecret.
     */
    FAILSE(-1,"失败"),
    /**
     * regionId.
     */
    REGIONID(2,"cn-hangzhou"),
    /**
     * appKey.
     */
    APPKEY(4,"appKey");

    ResultCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 编码.
     */
    private Integer code;
    /**
     * 消息.
     */
    private String msg;

    public Integer code() {
        return this.code;
    }


    public String msg() {
        return this.msg;
    }

    /**
     * 得到枚举值.
     *
     * @param it 值.
     * @return  .
     */
    public static ResultCode valueAs(Long it) {
        ResultCode[] enums = values();
        for (ResultCode item : enums) {
            if (item.code().equals(it) ) {
                return item;
            }
        }
        throw new RuntimeException("非法值 [" + it + "]");
    }
}
