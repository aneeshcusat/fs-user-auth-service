package com.fs.service.auth.service;

import com.fs.service.auth.payload.request.CreateUserRequest;
import com.fs.service.auth.payload.request.AuthRequest;
import com.fs.service.auth.payload.response.AuthResponse;
import com.fs.service.auth.payload.response.UserDetailsResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserService {
    UserDetailsResponse getUserById(Long userId) throws UsernameNotFoundException;

    UserDetailsResponse getUserByEmailId(String emailId) throws UsernameNotFoundException;

    AuthResponse login(AuthRequest authRequest);

    AuthResponse refreshToken(AuthRequest authRequest);

    UserDetailsResponse create(CreateUserRequest createUser);
}
