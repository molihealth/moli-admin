package com.moli.admin.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Created by gary on 17/8/25.
 */
public class Result {
    public static final Result SUCCESS      = new Result(ResultCode.SUCCESS);
    public static final Result UNKOWN_ERROR = new Result(ResultCode.UNKNOWN_ERROR);
    public static final Result PARAM_ERROR  = new Result(ResultCode.PARAM_ERROR);

    private int                code;
    private String             msg;
    private Object             data;

    /**
     * 使用fastjson转化成string，使用了三个参数：SerializerFeature.WriteMapNullValue,
     * SerializerFeature.WriteNullListAsEmpty,
     * SerializerFeature.WriteNullStringAsEmpty
     *
     * @return
     */
    public String toJsonString() {
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    /**
     * 使用和 {@linkplain #toJsonString()}相同的实现
     */
    @Override
    public String toString() {
        return this.toJsonString();
    }

    public Result(int code) {
        this(code, null, null);
    }

    public Result(ResultCode code) {
        this(code.getValue(), code.getDesc(), null);
    }

    public Result(ResultCode code, Object data) {
        this(code.getValue(), code.getDesc(), data);
    }

    public Result(int code, String msg) {
        this(code, msg, null);
    }

    public Result(int code, Object data) {
        this(code, null, data);
    }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(Object data) {
        return new Result(ResultCode.SUCCESS, data);
    }

    public static Result fail(String message) {
        return new Result(ResultCode.COMMON_ERROR.getValue(), message, null);
    }

    public static Result fail(ResultCode resultCode) {
        return new Result(resultCode.getValue(), resultCode.getDesc(), null);
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
