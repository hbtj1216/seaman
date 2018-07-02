package com.tao.seaman.upm.common.enums;

/**
 * upm系统接口结果常量枚举类
 * @creater tao
 * @time 2018/6/18
 */
public enum UpmResultEnum {

    /**
     * 失败
     */
    FAILED(0, "failed"),

    /**
     * 成功
     */
    SUCCESS(1, "SUCCESS"),

    /**
     * 无效长度
     */
    INVALID_LENGTH(1001, "invalid length"),

    /**
     * 用户名不能为空
     */
    EMPTY_USERNAME(10101, "username connot be empty"),

    /**
     * 密码不能为空
     */
    EMPTY_PASSWORD(10102, "password connot be empty"),

    /**
     * 用户名不存在
     */
    INVALID_USERNAME(10103, "username does not exist"),

    /**
     * 密码错误
     */
    INVALID_PASSWORD(10104, "password error"),

    /**
     * 无效账户
     */
    INVALID_ACCOUNT(10105, "invalid account");


    /**
     * 常量码
     */
    private int code;

    /**
     * 常量信息
     */
    private String message;


    UpmResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
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
}
