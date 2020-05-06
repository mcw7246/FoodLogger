package com.foodlogger.ui;

import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GetSignInRoute implements Route
{
  final String VIEW_NAME = "signin.ftl";
  final String TITLE_ATTR = "title";


  TemplateEngine templateEngine;
  public GetSignInRoute(TemplateEngine templateEngine){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");
    this.templateEngine = templateEngine;
  }

  @Override
  public Object handle(Request request, Response response){
    Map<String, Object> vm = new HashMap<>();

    vm.put(TITLE_ATTR, "Sign in to FoodLogger!");

    vm.put("signinerrormsg", "Please sign in!");

    return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
  }
}
