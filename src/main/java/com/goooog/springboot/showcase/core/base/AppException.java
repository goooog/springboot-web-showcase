package com.goooog.springboot.showcase.core.base;

/**
 * Created by young on 2017/9/17.
 */
public class AppException extends RuntimeException {

    private int code;

    public AppException(int code) {
        this.code = code;
    }

    public AppException(int code, String message) {
        super(message);
        this.code = code;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
