package com.foodlogger.ui;

import com.foodlogger.application.DatabaseManager;
import com.foodlogger.model.AccountVerification;
import com.foodlogger.model.User;
import spark.*;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.halt;

public class PostSignInRoute implements Route
{
  //
  // Static methods
  //
  static final String USERNAME_PARAM = "username";
  static final String MESSAGE_ATTR = "message";
  static final String SIGNIN_ERROR_KEY = "signinerror";
  static final String ERROR_KEY = "errormsg";

  static final String PSW_PARAM = "psw";
  static final String UNAME_PARAM = "uname";

  static final String VIEW_NAME = "signin.ftl";

  private final TemplateEngine templateEngine;
  private final DatabaseManager databaseManager;

  public PostSignInRoute(TemplateEngine templateEngine, DatabaseManager databaseManager){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null.");
    Objects.requireNonNull(databaseManager, "databaseManager must not be null.");
    this.templateEngine = templateEngine;
    this.databaseManager = databaseManager;
  }

  @Override
  public String handle(Request request, Response response){
    final Map<String, Object> vm = new HashMap<>();
    vm.put(GetHomeRoute.TITLE_ATTR, GetHomeRoute.TITLE);

    final Session session = request.session();

    //checks if there is already a user signed in
    if(session.attribute(GetHomeRoute.USER_KEY) == null){
      ModelAndView mv = null;

      //gets the username and password from what was put into the
      //signin.ftl file
      final String username = request.queryParams(UNAME_PARAM);
      final String password = request.queryParams(PSW_PARAM);

      System.out.println("Username: " + username);
      System.out.println("Password: " + password);

      AccountVerification av = new AccountVerification(databaseManager, templateEngine);

      //looks to see if the password and username given matches credentials for
      //an existing user
      try
      {
        if (databaseManager.hasRecord(username)){
          if(databaseManager.passwordMatches(username, password)){
            session.attribute(GetHomeRoute.USERNAME_KEY, username);
            response.redirect(WebServer.HOME_URL);
          }
        }else{
          System.out.println("something went wrong!");
        }
      }catch(SQLException e){
        System.out.println(e.getMessage());
      }
      return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
    else{
      response.redirect(WebServer.SIGNIN_URL);
      halt();
      return null;
    }
  }
}
