package com.foodlogger.ui;

import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PostSignUpRoute implements Route
{
  static final String VIEW_NAME = "signup.ftl";

  TemplateEngine templateEngine;
  public PostSignUpRoute(TemplateEngine templateEngine){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");
  }

  public String handle(Request request, Response response){
    final Map<String, Object> vm = new HashMap<>();
    vm.put(GetHomeRoute.TITLE_ATTR, GetHomeRoute.TITLE);

    final Session session = request.session();

    return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
  }

}
