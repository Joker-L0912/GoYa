package com.goya.core.exception.user;

import com.goya.core.enums.ReturnCode;
import com.goya.core.exception.BaseException;

import java.io.Serial;

public class UserException extends BaseException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UserException(String code, String message) {
        super(code, message);
    }

    public UserException(ReturnCode returnCode) {
        super(returnCode);
    }
}
