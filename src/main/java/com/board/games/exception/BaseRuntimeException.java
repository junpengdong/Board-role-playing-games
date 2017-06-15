package com.board.games.exception;

import java.util.Arrays;

public class BaseRuntimeException extends RuntimeException {

    //用于存储变量
    private Object[] params;

    public BaseRuntimeException(String message, Object... params) {
        super(message);
        this.params = params;
    }

    public BaseRuntimeException(String message, Throwable cause, Object... params) {
        super(message, cause);
        this.params = params;
    }

    public BaseRuntimeException(Throwable cause, Object... params) {
        super(cause);
        this.params = params;
    }

    public String getParams() {
        return Arrays.toString(params);
    }

}
