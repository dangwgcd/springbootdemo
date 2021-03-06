package com.my.config;

import com.my.common.CommonJsonResult;
import com.my.common.ProcessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wt on 2017/11/20.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonJsonResult handle(Exception e) {
        if (e instanceof ProcessException) {
            ProcessException processException = (ProcessException) e;
            return new CommonJsonResult(processException.getMessage());
        }else {
            LOGGER.error("【系统异常】{}", e);
            return new CommonJsonResult("未知错误");
        }
    }
}
