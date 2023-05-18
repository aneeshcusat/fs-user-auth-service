package com.fs.service.auth.repository;

import com.fs.service.auth.repository.models.UserRepositoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserJpaRepository extends JpaRepository<UserRepositoryModel, Long> {
  Optional<UserRepositoryModel>  findByEmail(String email);
}
