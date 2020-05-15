package com.foodlogger.ui;

import com.foodlogger.application.DatabaseManager;
import spark.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.halt;

public class PostSignInRoute implements Route
{
  TemplateEngine templateEngine;
  DatabaseManager databaseManager;

  final String VIEW_NAME = "signin.ftl";

  final String EMAIL_PARAM = "email";
  final String PASSWORD_PARAM = "psw";



  public PostSignInRoute(TemplateEngine templateEngine, DatabaseManager databaseManager){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");
    Objects.requireNonNull(databaseManager, "databaseManager must not be null");
    this.templateEngine = templateEngine;
    this.databaseManager = databaseManager;
  }

  @Override
  public String handle(Request request, Response response){
    Session session = request.session();

    Map<String, Object> vm = new HashMap<>();

    vm.put(GetHomeRoute.TITLE_ATTR, GetHomeRoute.TITLE);

    //gets what the user submits as the email and the password
    final String email = request.queryParams(EMAIL_PARAM);
    final String password = request.queryParams(PASSWORD_PARAM);


    System.out.println("Email: " + email);
    System.out.println("Password: " + password);

    //if there was no email field
    if(email == null){
      vm.put("signinerrormsg", "Please enter an email");
      return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
    else{
      try{
        //email is already linked to an account
        if(databaseManager.hasRecord(email)){
          //password matches and sends user back to home page
          if(databaseManager.passwordMatches(email, password)){
            vm.replace(GetHomeRoute.SIGNIN_KEY, true);
            session.attribute(GetHomeRoute.SIGNIN_KEY, true);
            session.attribute(GetHomeRoute.EMAIL_ATTR, email);
            response.redirect(WebServer.HOME_URL);
            halt();
          }
          //password doesn't match
          else{
            vm.put("signinerrormsg", "The passwords don't match. Please try again.");
            return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
          }
        }else{
          vm.put("signinerrormsg", "We don't have any record of this email. Please try again or create a new account.");
          return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
        }
      }catch(SQLException e){
        System.out.println(e.getMessage());
      }

    }
    response.redirect(WebServer.HOME_URL);
    return null;
  }

}
