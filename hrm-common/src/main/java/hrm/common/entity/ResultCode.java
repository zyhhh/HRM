package hrm.common.entity;

/**
 * 公共的返回码
 *    返回码code：
 *      成功：1111
 *      失败：0000
 *      未登录：1001
 *      未授权：1002
 *      抛出异常：9999
 *      用户名或密码错误：2001
 */
public enum ResultCode {

    SUCCESS(true,1111,"操作成功！"),
    //---系统错误返回码-----
    FAIL(false,0000,"操作失败"),
    UNAUTHENTICATED(false,1001,"您还未登录"),
    UNAUTHORISE(false,1002,"权限不足"),
    SERVER_ERROR(false,9999,"抱歉，系统繁忙，请稍后重试！"),

    //---用户操作返回码  2xxx----
    MOBILEORPASSWORDERROR(false,2001,"用户名或密码错误");

    //---用户操作返回码  3xxx----
    //---权限操作返回码----
    //---其他操作返回码----

    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    ResultCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return success;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

}
