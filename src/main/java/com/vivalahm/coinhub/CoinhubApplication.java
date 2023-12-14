package com.vivalahm.coinhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients// Feign Client를 사용하기 위해 필요한 어노테이션
public class CoinhubApplication {

  public static void main(String[] args) {
    SpringApplication.run(CoinhubApplication.class, args);
  }

}
