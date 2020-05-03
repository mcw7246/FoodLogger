package com.foodlogger.ui;

import com.foodlogger.model.User;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class GetHomeRoute implements Route
{
  static final String TITLE_ATTR = "title";

  static final String TITLE = "Welcome to FoodLogger!";
  static final String VIEW_NAME = "home.ftl";

  static final String SIGNIN_KEY = "signin";
  static final String USERNAME_KEY = "username";
  static final String USER_KEY = "user";



  private static final Logger LOG = Logger.getLogger(GetHomeRoute.class.getName());
  private final TemplateEngine templateEngine;
  public GetHomeRoute(final TemplateEngine templateEngine){
    this.templateEngine = Objects.requireNonNull(templateEngine, "templateEngine must not be null");
    LOG.config("GetHomeRoute is initialized");
  }

  @Override
  public Object handle(Request request, Response response){
    final Session session = request.session();

    final Map<String, Object> vm = new HashMap<>();

    vm.put(TITLE_ATTR, TITLE);
    User user = session.attribute(USER_KEY);
    //check if the user is signed in
    if(user == null){
      vm.put(SIGNIN_KEY, false);
      vm.put("username", "YOU ARENT LOGGED IN");
    }
    else{
      vm.put(SIGNIN_KEY, "Welcome back " + USERNAME_KEY);
    }

    vm.put("info", "hi");
    System.out.println(templateEngine.modelAndView(vm, VIEW_NAME));
    System.out.println(vm);
    return templateEngine.render(templateEngine.modelAndView(vm, VIEW_NAME));
  }
}

