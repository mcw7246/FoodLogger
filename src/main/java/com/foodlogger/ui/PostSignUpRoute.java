package com.foodlogger.ui;

import com.foodlogger.application.DatabaseManager;
import com.foodlogger.model.AccountVerification;
import spark.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.halt;

public class PostSignUpRoute implements Route
{
  static final String VIEW_NAME = "signup.ftl";

  static final String SIGNUP_MSG_ATTR = "signupmsg";

  static final String NAME_KEY = "fname";
  static final String EMAIL_KEY = "email";
  static final String USERNAME_KEY = "username";
  static final String PASSWORD_KEY = "psw";

  TemplateEngine templateEngine;
  DatabaseManager databaseManager;
  public PostSignUpRoute(TemplateEngine templateEngine, DatabaseManager databaseManager){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");
    this.templateEngine = templateEngine;
    Objects.requireNonNull(databaseManager, "databaseManager must not be null");
    this.databaseManager = databaseManager;
  }

  public Object handle(Request request, Response response){
    final Map<String, Object> vm = new HashMap<>();
    vm.put(GetHomeRoute.TITLE_ATTR, GetHomeRoute.TITLE);

    AccountVerification accountVerification = new AccountVerification(databaseManager, templateEngine);

    final Session session = request.session();

    final String email = request.queryParams(EMAIL_KEY);
    final String fname = request.queryParams(NAME_KEY);
    final String username = request.queryParams(USERNAME_KEY);
    final String psw = request.queryParams(PASSWORD_KEY);

    System.out.println(username);
    System.out.println(psw);
    System.out.println("email: " + email);
    System.out.println("fname: " + fname);

    try{
      if(databaseManager.hasRecord(username)){
        vm.put(SIGNUP_MSG_ATTR, "The username is already taken. Please choose another");
        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
      }
      else{
        databaseManager.addUser(email, fname, username, psw);
        response.redirect(WebServer.HOME_URL);
        halt();
      }
    }catch(SQLException e){
      System.out.println(e.getMessage());
    }


    return null;
  }

}
