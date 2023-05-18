package com.fs.service.auth.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class ErrorResponse {
    private ErrorCode code;
    private String message;

    public enum ErrorCode {
        USER_INVALID_CREDENTIALS,
        ACCESS_RESTRICTED
    }
}
