package com.example.vhr.exception;

import com.example.vhr.entity.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public RespBean handleException(Exception e) {
        e.printStackTrace();
        return RespBean.error("服务器异常：" + e.getMessage());
    }
}