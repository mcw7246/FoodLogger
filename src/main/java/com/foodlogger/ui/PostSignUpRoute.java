package com.foodlogger.ui;

import com.foodlogger.application.DatabaseManager;
import com.foodlogger.model.User;
import spark.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.halt;

public class PostSignUpRoute implements Route
{
  TemplateEngine templateEngine;
  DatabaseManager databaseManager;

  final String SIGNUP_MSG_ATTR = "signuperrormsg";
  final String TITLE_ATTR = "title";

  final String VIEW_NAME = "signup.ftl";

  public PostSignUpRoute(TemplateEngine templateEngine, DatabaseManager databaseManager){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");
    Objects.requireNonNull(databaseManager, "databaseManager must not be null.");
    this.databaseManager = databaseManager;
    this.templateEngine = templateEngine;
  }

  @Override
  public String handle(Request request, Response response){
    Session session = request.session();

    Map<String, Object> vm = new HashMap<>();

    vm.put(TITLE_ATTR, "Sign up for Food Logger!");

    String name = request.queryParams("name");
    String email = request.queryParams("email");
    String psw = request.queryParams("psw");

    //if one of the fields is null, they have to be filed in
    if(name == null || email == null || psw == null){
      vm.put(SIGNUP_MSG_ATTR, "All of these fields must be filled.");
      return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }

    try{
      //the email is already taken
      if(databaseManager.hasRecord(email)){
        vm.put(SIGNUP_MSG_ATTR, "This email is already associated with an account. Please log into this account or " +
                "try another email.");
        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
      }
      else{
        //adds the user to the database
        databaseManager.addUser(email, name, psw);
        User user = new User();

        //sets the userkey to the new user and the signin boolean
        session.attribute(GetHomeRoute.USER_KEY, user);
        session.attribute(GetHomeRoute.SIGNIN_KEY, true);
        response.redirect(WebServer.HOME_URL);
      }
    }catch(SQLException e){
      System.out.println(e.getMessage());
    }


    return null;
  }
}
