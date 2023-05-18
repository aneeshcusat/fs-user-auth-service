package com.fs.service.auth.payload.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.validation.constraints.*;

@Data
@Builder
public class CreateUserRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String name;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private String role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;
}
