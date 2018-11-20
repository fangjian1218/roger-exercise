package com.roger.enums;

public enum ResultCodeEnum {

    SUCCESS("200", "SUCCESS"), FAIL("400", "访问失败");
    private String resultCode;
    private String resultMsg;

    ResultCodeEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
