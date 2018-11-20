package com.roger.utils;

import com.roger.enums.ResultCodeEnum;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


public class Result<T> implements Serializable {

    private static final long serialVersionUID = 8108380018079905747L;

    @ApiModelProperty(value = "返回代码", name = "resultCode", example = "200", required = true)
    private String resultCode;

    @ApiModelProperty(value = "返回信息", name = "resultMsg", example = "success", required = true)
    private String resultMsg;

    @ApiModelProperty(value = "data", name = "equip_no", example = "返回的json字符串", required = true)
    private T data;

    public Result() {
    }

    public Result(ResultCodeEnum resultCode) {
        this.resultCode = resultCode.getResultCode();
        this.resultMsg = resultCode.getResultMsg();
    }

    public Result(ResultCodeEnum resultCode, T data) {
        this.resultCode = resultCode.getResultCode();
        this.resultMsg = resultCode.getResultMsg();
        this.data = data;
    }

    public Result setCode(ResultCodeEnum resultCode) {
        this.resultCode = resultCode.getResultCode();
        this.resultMsg = resultCode.getResultMsg();
        return this;
    }

    public String getResultCode() {
        return resultCode;
    }

    public Result setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public Result setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

}
