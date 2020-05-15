package com.foodlogger.ui;

import com.foodlogger.application.DatabaseManager;
import spark.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class PostLogFoodRoute implements Route
{
  TemplateEngine templateEngine;
  DatabaseManager databaseManager;

  final static String VIEW_NAME = "logfood.ftl";

  final static String FOOD_KEY = "food";
  final static String CALORIES_KEY = "calories";
  final static String DATE_KEY = "date";
  final static String TITLE_KEY = "title";

  public PostLogFoodRoute(TemplateEngine templateEngine, DatabaseManager databaseManager){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null.");
    Objects.requireNonNull(databaseManager, "databaseManager must not be null.");

    this.templateEngine = templateEngine;
    this.databaseManager = databaseManager;
  }

  @Override
  public Object handle(Request request, Response response){
    Session session = request.session();

    Map<String, Object> vm = new HashMap<>();

    vm.put(TITLE_KEY, "Log your food");

    final String foodType = request.queryParams(FOOD_KEY);
    final String caloriesCount = request.queryParams(CALORIES_KEY);
    final String dateConsumed = request.queryParams(DATE_KEY);

    System.out.println(dateConsumed);
    try{
      databaseManager.addFood(session.attribute(GetHomeRoute.EMAIL_ATTR), foodType, dateConsumed, caloriesCount);
    }catch(SQLException e){
      System.out.println(e.getMessage());
    }


    return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
  }
}
