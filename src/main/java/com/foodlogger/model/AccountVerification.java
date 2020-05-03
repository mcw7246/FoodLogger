package com.foodlogger.model;

import com.foodlogger.application.DatabaseManager;
import spark.TemplateEngine;

import java.sql.SQLException;
import java.util.Objects;

public class AccountVerification
{
  DatabaseManager databaseManager;
  TemplateEngine templateEngine;
  public AccountVerification(DatabaseManager database, TemplateEngine templateEngine){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");
    Objects.requireNonNull(database, "databaseManager must not be null");

    this.databaseManager = database;
    this.templateEngine = templateEngine;
  }

  public boolean usernameVerification(String username){
    //if there is no username
    try{
      if(databaseManager.hasRecord(username)){

        System.out.println("it is already a user");
        return false;
      }
      else{
        System.out.println("new user");
        return true;
      }


    }catch(SQLException e){
      System.out.println(e.getMessage());
    }
    return false;
  }
}
