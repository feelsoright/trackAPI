package com.loki.rfidtrack.apitrack.common.handler;
import com.loki.rfidtrack.apitrack.common.entity.Result;
import com.loki.rfidtrack.apitrack.common.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class BaseExceptionHandler {
	
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e){
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
