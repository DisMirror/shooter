package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
  @Value("${eureka.client.serviceUrl.defaultZone}")
  private String profile;
  @Autowired
  private ContextRefresher contextRefresher;

  @GetMapping("/profile")
  public String hello() {
    contextRefresher.refresh();
    return this.profile;
  }
}
