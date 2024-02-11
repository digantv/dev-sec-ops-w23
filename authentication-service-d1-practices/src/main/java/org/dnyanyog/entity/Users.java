package org.dnyanyog.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users { // Table
  @GeneratedValue // Auto generated (DB => sequence), primary key
  @Id
  @Column(name = "userCode", nullable = false, updatable = false, insertable = false)
  private long userCode;
  @Column(name = "userId", nullable = false, updatable = false)
  private long userId;
  @Column(name = "username", nullable = false, length = 50)
  private String username;
  @Column private String password;
  @Column private String email;
  @Column private String age;

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "Users [userId="
        + userId
        + ", username="
        + username
        + ", password="
        + password
        + ", email="
        + email
        + ", age="
        + age
        + "]";
  }
}
