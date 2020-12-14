package com.hrm.common.exception;

import com.hrm.common.entity.ResultCode;
import lombok.Getter;

/**
 * 公共异常类
 * @author ASUS
 * @date 2020-12-14
 */
@Getter
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ResultCode code = ResultCode.SERVER_ERROR;

    public CommonException() {
    }

    public CommonException(ResultCode code) {
        super(code.message());
        this.code = code;
    }
}
