package com.foodlogger.ui;

import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GetSignUpRoute implements Route
{
  static final String VIEW_NAME = "signup.ftl";

  static final String SIGNUP_MSG_ATTR = "signupmsg";

  TemplateEngine templateEngine;
  public GetSignUpRoute(TemplateEngine templateEngine){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");
    this.templateEngine = templateEngine;
  }

  public Object handle(Request request, Response response){
    Map<String, Object> vm = new HashMap<>();

    vm.put("title", "Sign up");
    vm.put(SIGNUP_MSG_ATTR, "Please sign up.");
    return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
  }

}
