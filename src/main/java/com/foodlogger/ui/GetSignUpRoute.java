package com.foodlogger.ui;

import com.foodlogger.application.DatabaseManager;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GetSignUpRoute implements Route
{

  final String VIEW_NAME = "signup.ftl";
  final String TITLE_ATTR = "title";
  final String SIGNUP_ERROR_ATTR = "signuperrormsg";

  TemplateEngine templateEngine;
  DatabaseManager databaseManager;
  public GetSignUpRoute(TemplateEngine templateEngine, DatabaseManager databaseManager){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");
    Objects.requireNonNull(databaseManager, "databaseManager must not be null");
    this.templateEngine = templateEngine;
    this.databaseManager = databaseManager;
  }

  @Override
  public Object handle(Request request, Response response){
    Map<String, Object> vm = new HashMap<>();

    vm.put(TITLE_ATTR, "Sign up!");
    vm.put(SIGNUP_ERROR_ATTR, "FUcK");

    return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
  }
}
