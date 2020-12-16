package com.hrm.common.exception;

import com.hrm.common.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 * @author ASUS
 * @date 2020-12-14
 */
@ControllerAdvice
public class BaseExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result errCatch(HttpServletRequest request, HttpServletResponse response, Exception ex){
        ex.printStackTrace();
        if(ex.getClass() == CommonException.class){
            CommonException cex = (CommonException) ex;
            return new Result(cex.getCode());
        } else {
            return Result.ERROR().message("系统内部错误："+ex.getMessage());
        }
    }
}
