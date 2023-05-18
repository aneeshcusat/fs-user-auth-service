package com.fs.service.auth.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class GeneralResponse {
    boolean success;
}