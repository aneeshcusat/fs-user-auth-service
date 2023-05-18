package com.fs.service.auth.payload.response;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@ToString
public class ServiceResponse {
    private Object payload;
    private List<ErrorResponse> error;
    private MetaData metaData;

    @Data
    @Builder
    @ToString
    public static  class MetaData {
        private Long userId;
    }
}
