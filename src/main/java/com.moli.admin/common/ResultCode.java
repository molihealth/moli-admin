package com.moli.admin.common;

/**
 * Created by gary on 17/8/25.
 */
public enum ResultCode {
    SUCCESS(200, "成功返回"),
    UN_LOGIN(201, "请先登录"),
    UN_USER(202, "未查询到用户"),
    UNKNOWN_ERROR(404, "未知异常"),
    COMMON_ERROR(499, "通用错误"),
    PARAM_ERROR(40001, "参数不合法");

    private int    value;
    private String desc;

    private ResultCode(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String toString() {
        return "[" + this.value + ":" + this.desc + "]";
    }
}
