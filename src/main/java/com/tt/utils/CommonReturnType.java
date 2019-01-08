package com.tt.utils;

/**
 * @ Author     ：xyf
 * @ Date       ：Created in 2018/12/19 0019下午 8:52
 * @ Description：返回数据格式化类（即存储通用对象）
 * @ Modified By：xyf
 * @Version:
 */
public class CommonReturnType {

    //表名对应请求的处理结果为success或fail
    private String status;

    //若status=success,则data内返回前端需要的JSON数据
    //若status=fail,则data内返回通用的错误码格式（已在其他类或接口中定义）
    private Object data;


    public CommonReturnType() {
    }

    /**
     * create by: xyf
     * description: 这个方法的意义：如果返回的结果不带status，则返回的status为success
     * create time: 下午 9:00 2018/12/19 0019
     *
     * @return tt.response.CommonReturnType
     * @Param: result
     */
    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result, "success");
    }

    /**
     * create by: xyf
     * description:  创建CommonReturnType的方法
     * create time: 下午 8:58 2018/12/19 0019
     *
     * @return tt.response.CommonReturnType
     * @Param: result
     * @Param: status
     */
    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
