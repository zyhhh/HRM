package com.hrm.common.entity;

/**
 * 公共的返回码
 *    返回码code：
 *      成功：0000
 *      失败：1111
 *      未登录认证：1001
 *      未经授权：1002
 *      抛出异常：9999
 *      用户名或密码错误：2001
 */
public enum ResultCode {
    //---操作成功返回码
    SUCCESS(true,"0000","操作成功"),

    //---系统错误返回码 1xxx
    FAIL(false,"1111","操作失败"),
    UNAUTHENTICATED(false,"1001","您还未登录"),
    UNAUTHORISE(false,"1002","权限不足"),
    SERVER_ERROR(false,"9999","系统繁忙，请稍后重试"),

    //---用户操作返回码  2xxx
    NAMEORPASSWORDERROR(false,"2001","用户名或密码错误");

    //操作是否成功
    boolean success;
    //操作代码
    String code;
    //提示信息
    String message;

    ResultCode(boolean success, String code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return success;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }
}
