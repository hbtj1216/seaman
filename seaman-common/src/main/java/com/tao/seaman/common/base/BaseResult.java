package com.tao.seaman.common.base;

/**
 * 统一的返回结果基类
 * @author taojie6 2018/6/29 11:02
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2018/6/29 11:02
 * @modify by reason:{方法名}:{原因}
 */
public class BaseResult<T> {

    /**
     * 状态码: 1表示成功, 其他为失败
     */
    private int code;

    /**
     * 状态描述: 成功为success, 其他为失败
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    public BaseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
