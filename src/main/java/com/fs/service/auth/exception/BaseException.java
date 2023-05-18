package com.fs.service.auth.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -7437234570467024179L;
    private HttpStatus httpStatus;

    private ErrorCode code;

    public BaseException(String message, ErrorCode code, HttpStatus httpStatus, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
        this.code = code;
    }

    public BaseException(ErrorCode code, HttpStatus httpStatus) {
        super(code.getMessage());
        this.httpStatus = httpStatus;
        this.code = code;
    }

    public BaseException(String message, ErrorCode code) {
        super(message);
        this.code = code;
        this.httpStatus = HttpStatus.OK;
    }

    public BaseException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = ErrorCode.GENERAL;
    }

    public BaseException(String message) {
        super(message);
        this.code = ErrorCode.GENERAL;
        this.httpStatus = HttpStatus.OK;
    }


    public enum ErrorCode {
        USER_ACCOUNT_LOCKED("Account locked"),
        USER_UNABLE_TO_GENERATE_ACTIVATION_KEY("Unable to generate activation key"),
        USER_INVALID_CREDENTIALS("Invalid credentials"),
        GENERAL("General error"),
        USER_INVALID_ACTIVATION_KEY("Invalid actiavation key"),
        USER_ACCOUNT_ACTIVATION_FAILED("Unable to activate account"),
        USER_ACCOUNT_UNLOCK_FAILED("User account unlocked"),
        NOT_FOUND("Not found"),
        USER_ALREADY_EXIST("User already exists"),
        CREATE_FAILED("Create failed"),
        UPDATE_FAILED("Update failed"),
        DELETE_FAILED("Delete failed");
        @Getter
        final String message;

        ErrorCode(String message) {
            this.message = message;
        }

        ErrorCode() {
            this.message = "Generic Error";
        }
    }
}
