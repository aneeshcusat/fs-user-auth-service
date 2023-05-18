package com.fs.service.auth.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class NotFoundException extends BaseException {

    public NotFoundException(ErrorCode code) {
        super(code, HttpStatus.OK);
    }

}
