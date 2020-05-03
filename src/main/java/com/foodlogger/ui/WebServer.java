package com.foodlogger.ui;

import com.foodlogger.application.DatabaseManager;
import com.foodlogger.model.User;
import spark.TemplateEngine;

import javax.xml.crypto.Data;
import java.util.Objects;
import java.util.logging.Logger;

import static spark.Spark.*;


public class WebServer
{
  private static final Logger LOG = Logger.getLogger(WebServer.class.getName());


  public static final String HOME_URL = "/";
  public static final String SIGNIN_URL = "/signin";
  public static final String SIGNUP_URL = "/signup";
  private final TemplateEngine templateEngine;
  private final DatabaseManager databaseManager;

  public WebServer(final TemplateEngine templateEngine, DatabaseManager databaseManager){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");
    Objects.requireNonNull(databaseManager, "databaseManager must not be null");
    this.databaseManager = databaseManager;
    this.templateEngine = templateEngine;
    LOG.config("WebServer");
  }

  public void initialize(){
    //includes the css and javascript files
    staticFileLocation("/public");

    get(HOME_URL, new com.foodlogger.ui.GetHomeRoute(templateEngine));
    get(SIGNIN_URL, new GetSignInRoute(templateEngine));
    post(SIGNIN_URL, new PostSignInRoute(templateEngine, databaseManager));
    get(SIGNUP_URL, new GetSignUpRoute(templateEngine));
    post(SIGNUP_URL, new PostSignUpRoute(templateEngine, databaseManager));
  }

}
