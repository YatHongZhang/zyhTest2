package com.zyh.zyhTest.enums;

import lombok.Getter;

/**
 * Created by Administrator on 2017/6/28/0028.
 */
@Getter
public enum ResponseEnum {
    SYSTEM_ERROR("019999","前置系统内部错误"),

    SIGN_ERROR("010000","验签失败"),
    SIGN_EMPTY("010001","数字签名不能为空"),
    USER_ACCOUNT_EMPTY("010002","用户账户不能为空"),
    TOKEN_EXPIRED("010003","会话已过期,请重新登陆"),
    TOKEN_EMPTY("010004","token不能为空"),
    TOKEN_DIFFERENT("010005","您的账号已在其他设备登陆"),
    TRACE_LOG_ID_EMPTY("010006","日志跟踪ID不能为空"),
    ILLEGAL_PARAMS("010007","请求参数包含非法字符"),
    JSON_PARAM_EMPTY("010008","请求参数不能为空")
    ;
    private String errorCode;
    private String errorMsg;

    ResponseEnum(String code, String desc) {
        this.errorCode = code;
        this.errorMsg = desc;
    }
}
