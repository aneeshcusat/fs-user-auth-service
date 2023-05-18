package com.fs.service.auth.security.services;

import com.fs.service.auth.exception.BaseException;
import com.fs.service.auth.exception.NotFoundException;
import com.fs.service.auth.exception.SecurityException;
import com.fs.service.auth.repository.IUserJpaRepository;
import com.fs.service.auth.repository.models.UserRepositoryModel;
import com.fs.service.auth.payload.response.UserSecurityDetails;
import com.fs.service.auth.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  IUserJpaRepository jpaRepository;

  @Autowired
  UserMapper userMapper;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
    UserRepositoryModel userRepositoryModel = jpaRepository.findByEmail(emailId).orElse(null);

    if (Objects.isNull(userRepositoryModel)) {
      throw new NotFoundException(BaseException.ErrorCode.NOT_FOUND);
    }
    return UserSecurityDetails.builder()
            .id(userRepositoryModel.getId())
            .name(userRepositoryModel.getName())
            .role(userRepositoryModel.getRole())
            .email(userRepositoryModel.getEmail())
            .password(userRepositoryModel.getPassword())
            .authorities(List.of(new SimpleGrantedAuthority(userRepositoryModel.getRole())))
            .build();
  }
}
