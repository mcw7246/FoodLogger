package com.foodlogger.application;

import com.foodlogger.model.User;
import spark.TemplateEngine;

import java.util.Objects;

public class AccountManager
{
  private String password;
  private String username;

  User user;
  TemplateEngine templateEngine;
  public AccountManager(TemplateEngine templateEngine, User user){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null.");
    Objects.requireNonNull(user, "user must not be null");

    this.user = user;
    this.templateEngine = templateEngine;
  }




}
