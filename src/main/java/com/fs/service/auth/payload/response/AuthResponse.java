package com.fs.service.auth.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@Builder
@ToString
public class AuthResponse {
    private String authToken;
    private String authRefreshToken;
    private Long userId;
    private UserDetailsResponse userDetails;
    private List<String> roles;
}
