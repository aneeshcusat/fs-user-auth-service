package com.fs.service.auth.repository.models;

import com.fs.service.auth.mapping.table.TableNameMapping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@SuperBuilder(toBuilder=true)
@Table(name = TableNameMapping.TableUserModel.TABLE_NAME)
public class UserRepositoryModel extends BaseRepositoryModel {

  private static final long serialVersionUID = 3761403806130362758L;

  @Id
  @Column(name = TableNameMapping.TableBaseModel.id, nullable = false)
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column(name = TableNameMapping.TableUserModel.email)
  private String email;

  @Column(name = TableNameMapping.TableUserModel.password)
  private String password;

  @Column(name = TableNameMapping.TableUserModel.name)
  private String name;

  @Column(name = TableNameMapping.TableUserModel.role)
  private String role;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    UserRepositoryModel that = (UserRepositoryModel) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
