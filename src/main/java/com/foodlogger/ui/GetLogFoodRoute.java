package com.foodlogger.ui;

import com.foodlogger.application.DatabaseManager;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GetLogFoodRoute implements Route
{
  static final String VIEW_NAME = "logfood.ftl";

  TemplateEngine templateEngine;
  DatabaseManager databaseManager;

  public GetLogFoodRoute(TemplateEngine templateEngine, DatabaseManager databaseManager){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");
    Objects.requireNonNull(databaseManager, "databaseManager must not be null");
    this.templateEngine = templateEngine;
    this.databaseManager = databaseManager;
  }

  @Override
  public Object handle(Request request, Response response){
    Session session = request.session();

    Map<String, Object> vm = new HashMap<>();

    vm.put("title", "Log Food!");


    return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
  }

}
