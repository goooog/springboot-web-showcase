package com.goooog.springboot.showcase.core;

import com.alibaba.fastjson.JSON;
import com.goooog.springboot.showcase.core.base.AppContants;
import com.goooog.springboot.showcase.core.base.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Order(1)
@ControllerAdvice(basePackages = AppContants.API_BASE_PACKAGE)
public class ApiResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private static final Logger logger = LoggerFactory.getLogger(ApiResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                    Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                    ServerHttpResponse response) {
        Response<Object> resp = new Response<>();
        resp.setStatus(0);
        resp.setMsg("success");
        resp.setData(body);

        if(returnType.getMethod().getReturnType() == String.class){
            return JSON.toJSONString(resp);
        }else{
            return resp;
        }

    }


}
