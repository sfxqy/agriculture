package com.wisdom.agriculture.exception;

/**
 * @author SFX
 * 分页异常类
 */
public class PagingException  extends RuntimeException {
    public PagingException() {
        super();
    }

    public PagingException(String message) {
        super(message);
    }

    public PagingException(String message, Throwable cause) {
        super(message, cause);
    }

    public PagingException(Throwable cause) {
        super(cause);
    }

    protected PagingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
