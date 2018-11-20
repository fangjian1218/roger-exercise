package com.roger.utils;

import com.roger.enums.ResultCodeEnum;

public class ResultUtil {

    public static final String DEFAULT_SUCCESS_MESSAGE = "success";

    public static Result successResult() {
        return new Result().setCode(ResultCodeEnum.SUCCESS).setResultMsg(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result successResult(Object data) {
        return new Result().setCode(ResultCodeEnum.SUCCESS).setResultMsg(DEFAULT_SUCCESS_MESSAGE).setData(data);
    }

    public static Result failResult(String message) {
        return new Result().setCode(ResultCodeEnum.FAIL).setResultMsg(message);
    }
}
