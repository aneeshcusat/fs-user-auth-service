package com.fs.service.auth.repository.mapper;

import com.fs.service.auth.repository.models.UserRepositoryModel;
import com.fs.service.auth.payload.request.CreateUserRequest;
import com.fs.service.auth.payload.response.UserDetailsResponse;
import org.springframework.stereotype.Component;
@Component
public class UserMapper {


   public UserDetailsResponse map(UserRepositoryModel userRepositoryModel) {
      return  UserDetailsResponse.builder()
              .id(userRepositoryModel.getId())
              .name(userRepositoryModel.getName())
              .email(userRepositoryModel.getEmail()).build();
   }

   public  UserRepositoryModel map(CreateUserRequest createUserRequest) {
      return  UserRepositoryModel.builder()
              .email(createUserRequest.getEmail())
              .name(createUserRequest.getName())
              .role(createUserRequest.getRole()).build();
   }
}
