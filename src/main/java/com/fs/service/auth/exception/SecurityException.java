package com.fs.service.auth.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class SecurityException extends BaseException {

    public SecurityException(ErrorCode code) {
        super(code, HttpStatus.OK);
    }

}
