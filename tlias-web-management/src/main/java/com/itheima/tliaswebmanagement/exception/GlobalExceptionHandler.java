package com.itheima.tliaswebmanagement.exception;

import com.itheima.tliaswebmanagement.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常处理器，用于统一处理系统中抛出的异常
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理通用异常
     * @param e 异常对象
     * @return 错误结果封装
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        log.error("程序出错啦~", e);
        return Result.error("出错啦, 请联系管理员~");
    }

    /**
     * 处理数据库重复键异常
     * @param e 重复键异常对象
     * @return 错误结果封装，包含具体的重复数据信息
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.error("程序出错啦~", e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error( arr[2] + " 已存在");
    }


    /**
     * 处理业务异常
     * @param businessException 业务异常对象
     * @return 错误结果封装，包含业务异常的具体信息
     */
    @ExceptionHandler(BusinessException.class)
    public Result handleBuinessException(BusinessException businessException) {
        log.error("服务器异常", businessException);
        return Result.error(businessException.getMessage());
    }
}

