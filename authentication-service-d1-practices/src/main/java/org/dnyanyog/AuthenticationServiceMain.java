package org.dnyanyog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;

@SpringBootApplication // API Application
public class AuthenticationServiceMain {
  public  static void main(String[] args) throws InterruptedException {
    SpringApplication.run(AuthenticationServiceMain.class, args);
  }
}
