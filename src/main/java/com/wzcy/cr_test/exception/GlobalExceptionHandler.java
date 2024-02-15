package com.wzcy.cr_test.exception;


import com.wzcy.cr_test.vo.UserResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


//全局异常处理类
@ControllerAdvice
public class GlobalExceptionHandler {
    /***
     *
     * @param ex
     * @return eduresult 页面同意返回结果集
     * 捕获所有的异常也就是说只要在这个项目里面
     * 任何位置报错了
     * 最后都会来到这里面执行代码
     * 可以把对象变成json输出到页面去
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public UserResult defaltErrorHandler(Exception ex, HttpServletResponse response) {
        //会打印报错日志在控制台上
        ex.printStackTrace();
        //从jsr303异常里面获取message
        String message = ex.getMessage();
        //设置状态码为500
        response.setStatus(500);
        if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            BindingResult getbindingresult = bindException.getBindingResult();
            ObjectError objectError = getbindingresult.getAllErrors().get(0);
            String defaultMessage = objectError.getDefaultMessage();
            if (defaultMessage.length() < 15) {
                return UserResult.error(defaultMessage);
            }

        }
//        if (ex instanceof MethodArgumentNotValidException) {
//            MethodArgumentNotValidException bindException = (MethodArgumentNotValidException) ex;
//            BindingResult getbindingresult = bindException.getBindingResult();
//            ObjectError objectError = getbindingresult.getAllErrors().get(0);
//            String defaultMessage = objectError.getDefaultMessage();
//            if (message.length() < 15) {
//                return UserResult.error(defaultMessage);
//            }
//
//        }
        //判断一下是否是我们抛出去的异常
        //不是我们自己写的异常而是运行过程中不小心出现的异常
        if (ex instanceof RuntimeException) {
            if (message.length() < 50) {
                return UserResult.error(message);
            }

        }
        return UserResult.error("出错了请联系管理员");
    }

    ;
}

