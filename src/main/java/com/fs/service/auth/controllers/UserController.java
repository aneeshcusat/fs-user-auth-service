package com.fs.service.auth.controllers;

import com.fs.service.auth.payload.request.CreateUserRequest;
import com.fs.service.auth.payload.request.AuthRequest;
import com.fs.service.auth.payload.response.GeneralResponse;
import com.fs.service.auth.payload.response.ServiceResponse;
import com.fs.service.auth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<ServiceResponse> authenticateUser(
            @NotNull @Valid @RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok().body(ServiceResponse.builder().payload(userService.login(authRequest)).build());
    }

    @PostMapping("/auth/refresh")
    public ResponseEntity<ServiceResponse> refreshToken(
            @NotNull @Valid @RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok().body(ServiceResponse.builder().payload(userService.refreshToken(authRequest)).build());
    }

    @PostMapping("/logout")
    public ResponseEntity<ServiceResponse> logOut(HttpRequest request) {
        SecurityContextHolder.getContext().setAuthentication(null);
        return ResponseEntity.ok().body(
                ServiceResponse.builder().payload(GeneralResponse.builder().success(true).build()).build());
    }

    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> createUser( @NotNull @Valid @RequestBody CreateUserRequest createUser) {
        return ResponseEntity.ok().body(ServiceResponse.builder().payload(userService.create(createUser)).build());

    }
}
