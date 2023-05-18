package com.fs.service.auth.payload.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class AuthRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
