package com.fs.service.auth;

import com.fs.service.auth.exception.BaseException;
import com.fs.service.auth.exception.SecurityException;
import com.fs.service.auth.payload.response.ErrorResponse;
import com.fs.service.auth.payload.response.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ServiceResponse> exception(RuntimeException e) {
        HttpStatus httpStatusCode = HttpStatus.UNPROCESSABLE_ENTITY;
        String message = BaseException.ErrorCode.GENERAL.getMessage();
        if(e instanceof BaseException) {
            httpStatusCode = ((BaseException) e).getHttpStatus();
        }
        if(e instanceof InternalAuthenticationServiceException) {
            httpStatusCode = HttpStatus.OK;
            message = BaseException.ErrorCode.USER_INVALID_CREDENTIALS.getMessage();

        }
        return ResponseEntity.status(httpStatusCode)
                .body(ServiceResponse.builder()
                        .error(
                                Collections.singletonList(ErrorResponse.builder().message(message).build()))
                        .build());
    }
}
