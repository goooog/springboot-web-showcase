package com.goooog.springboot.showcase.core;

import com.goooog.springboot.showcase.core.base.AppContants;
import com.goooog.springboot.showcase.core.base.AppException;
import com.goooog.springboot.showcase.core.base.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice(basePackages = AppContants.API_BASE_PACKAGE)
public class ApiExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final int UNKNOWN_EXCEPTION_STATUS = -2;
    private static final int ILLEGAL_ARGUMENT_STATUS = -1;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        Response response = new Response();
        if (e instanceof AppException) {
            response.setStatus(((AppException) e).getCode());
            response.setMsg(e.getMessage());
        } else if (e instanceof IllegalArgumentException) {
            response.setStatus(ILLEGAL_ARGUMENT_STATUS);
            response.setMsg(e.getMessage());
        } else {
            logger.error("Got exception,url=" + req.getRequestURI(), e);
            response.setStatus(UNKNOWN_EXCEPTION_STATUS);
            response.setMsg("接口异常");
        }

        return response;
    }

}
