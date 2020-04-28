package com.foodlogger.ui;

import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class GetSignInRoute implements Route
{
  private static final Logger LOG = Logger.getLogger(GetHomeRoute.class.getName());

  private final TemplateEngine templateEngine;

  public GetSignInRoute(final TemplateEngine templateEngine){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null.");
    this.templateEngine = templateEngine;
  }

  @Override
  public Object handle(Request request, Response response){
    LOG.finer("GetSigninRoute is invoked.");
    Map<String, Object> vm = new HashMap<>();

    vm.put("title", "Sign-in");

    return templateEngine.render(new ModelAndView(vm, "signin.ftl"));
  }
}
