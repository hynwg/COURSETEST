package com.course.business.controller;

import com.course.server.exception.BusinessException;
import com.course.server.exception.ValidatorException;
import com.course.server.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = ValidatorException.class)
    @ResponseBody
    public ResponseVo validatorExceptionHandler(ValidatorException e) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setSuccess(false);
        LOG.warn(e.getMessage());
        responseVo.setMessage(e.getMessage());//请求参数异常！
        return responseVo;
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseVo businessExceptionHandler(BusinessException e) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setSuccess(false);
        LOG.error("业务异常：{}", e.getCode().getDesc());
        responseVo.setMessage(e.getCode().getDesc());
        return responseVo;
    }
}
