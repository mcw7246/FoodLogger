package com.foodlogger.ui;

import com.foodlogger.model.User;
import spark.*;

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

  static final String VIEW_NAME = "signin.ftl";

  private final TemplateEngine templateEngine;

  public PostSignInRoute(TemplateEngine templateEngine){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null.");
    this.templateEngine = templateEngine;
  }

  @Override
  public String handle(Request request, Response response){
    final Map<String, Object> vm = new HashMap<>();
    vm.put(GetHomeRoute.TITLE_ATTR, GetHomeRoute.TITLE);

    final Session session = request.session();

    //checks if there is already a user signed in
    if(session.attribute(GetHomeRoute.USER_KEY) == null){
      ModelAndView mv = null;
      User user = new User();



      return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
    else{
      response.redirect(WebServer.SIGNIN_URL);
      halt();
      return null;
    }
  }
}
