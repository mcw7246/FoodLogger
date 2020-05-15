package com.foodlogger.ui;

import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class GetHomeRoute implements Route
{
  static final String TITLE_ATTR = "title";

  static final String HOME_MSG_KEY = "homemsg";
  static final String ACCOUNTMANAGER_KEY = "accountManager";
  static final String SIGNIN_KEY = "signin";

  static final String TITLE = "Welcome to FoodLogger!";

  static final String EMAIL_ATTR = "email";

  static final String VIEW_NAME = "home.ftl";


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

    vm.put(SIGNIN_KEY, false);

    //if the user is not signed in because it was a new session
    if(session.attribute(SIGNIN_KEY) == null){
      session.attribute(SIGNIN_KEY, false);
    }
    //the user is signed in
    if(session.attribute(SIGNIN_KEY)){
      vm.put(SIGNIN_KEY, true);
      vm.put(HOME_MSG_KEY, "Click on Log Food to get started!");
    }
    else{ //user is not signed in

    }


    return templateEngine.render(templateEngine.modelAndView(vm, VIEW_NAME));
  }
}

