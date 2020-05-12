package com.foodlogger.ui;

import com.foodlogger.application.DatabaseManager;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GetCalendarRoute implements Route
{
  final TemplateEngine templateEngine;
  final DatabaseManager databaseManager;

  static final String VIEW_NAME = "calendar.ftl";

  static final String TITLE_KEY = "title";

  public GetCalendarRoute(TemplateEngine templateEngine, DatabaseManager databaseManager){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null.");
    Objects.requireNonNull(databaseManager, "databaseManager must not be null.");
    this.databaseManager = databaseManager;
    this.templateEngine = templateEngine;
  }

  @Override
  public Object handle(Request request, Response response){
    Session session = request.session();

    Map<String, Object> vm = new HashMap<>();

    vm.put(TITLE_KEY, "Calendar");

    return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
  }
}
