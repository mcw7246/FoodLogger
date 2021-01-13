package com.foodlogger.ui;

import com.foodlogger.application.DatabaseManager;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PostCalendarRoute implements Route
{

  TemplateEngine templateEngine;
  DatabaseManager databaseManager;


  public PostCalendarRoute(TemplateEngine templateEngine, DatabaseManager databaseManager){
    Objects.requireNonNull(templateEngine, "TemplateEngine must not be null");
    Objects.requireNonNull(databaseManager, "DatabaseManager must not be null");
    this.templateEngine = templateEngine;
    this.databaseManager = databaseManager;
  }

  @Override
  public Object handle(Request request, Response response){

    final Map<String, Object> vm = new HashMap<>();
    vm.put(GetHomeRoute.TITLE_ATTR, "Calendar");

    final Session session = request.session();



    return "";

  }
}
