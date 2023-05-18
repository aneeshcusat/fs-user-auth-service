package com.fs.service.auth.payload.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsResponse{
  private static final long serialVersionUID = 1L;
  private Long id;
  private String name;
  private String email;
  private String role;
}
