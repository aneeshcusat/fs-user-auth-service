package com.fs.service.auth.service.impl;

import com.fs.service.auth.repository.models.UserRepositoryModel;
import com.fs.service.auth.payload.request.AuthRequest;
import com.fs.service.auth.payload.request.CreateUserRequest;
import com.fs.service.auth.payload.response.AuthResponse;
import com.fs.service.auth.payload.response.UserSecurityDetails;
import com.fs.service.auth.repository.IUserJpaRepository;
import com.fs.service.auth.repository.mapper.UserMapper;
import com.fs.service.auth.security.jwt.JwtUtils;
import com.fs.service.auth.payload.response.UserDetailsResponse;
import com.fs.service.auth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class UserService implements IUserService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUserJpaRepository userJpaRepository;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public UserDetailsResponse getUserById(Long userId) throws UsernameNotFoundException {
        return userJpaRepository.findById(userId).map(userMapper::map)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with user Id: " + userId));
    }
    @Override
    public UserDetailsResponse getUserByEmailId(String emailId) throws UsernameNotFoundException {
        return userJpaRepository.findByEmail(emailId).map(userMapper::map).orElse(null);
    }

    public AuthResponse login(@Valid @RequestBody AuthRequest authRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserSecurityDetails userDetails = (UserSecurityDetails) authentication.getPrincipal();
        return AuthResponse.builder()
                .userId(userDetails.getId())
                .userDetails(userDetails)
                .authToken(jwtUtils.generateJwtToken(authentication))
                .authRefreshToken(jwtUtils.generateJwtToken(authentication))
                .roles(userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public AuthResponse refreshToken(AuthRequest authRequest) {
        return null;
    }

    public UserDetailsResponse create(CreateUserRequest createUserRequest) {
        UserDetailsResponse userDetailsResponse = getUserByEmailId(createUserRequest.getEmail());
        if (Objects.nonNull(userDetailsResponse)) {
            throw new RuntimeException("Email id already in use");
        }
        UserRepositoryModel userRepositoryModel = userJpaRepository.save(userMapper.map(createUserRequest).toBuilder().password(encoder.encode(createUserRequest.getPassword())).build());
        return userMapper.map(userRepositoryModel);
    }
}
