package com.getdrop.recipe.common.security;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties(prefix = "spring.security")
public class BasicAuthUser {

  private String username;

  private String password;
}
