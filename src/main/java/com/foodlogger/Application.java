package com.foodlogger;

import com.foodlogger.application.DatabaseManager;
import com.google.gson.Gson;
import com.foodlogger.ui.WebServer;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.File;
import java.io.InputStream;
import java.sql.DatabaseMetaData;
import java.util.Objects;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Application
{
  private static final Logger LOG = Logger.getLogger(Application.class.getName());

  /**
   * Queries whether the application is being run in demo-mode.
   *
   * <p>
   * This method uses the memoization idiom so the calculation of
   * this value is only done once.
   *
   * @return true if 'demoMode' property is equal to 'true'; false if the
   * property isn't set or is not 'true'
   * @see <a href="https://en.wikipedia.org/wiki/Memoization">Memoization (wikipedia)</a>
   * </p>
   */
  public static boolean isInDemoMode()
  {
    if (inDemoMode == null)
    {
      inDemoMode = _isInDemoMode();
    }
    return inDemoMode;
  }

  private static final String DEMO_MODE_PROPERTY = "demoMode";
  private static Boolean inDemoMode = null;

  /**
   * The explicit, private property lookup method.
   */
  private static boolean _isInDemoMode()
  {
    final String demoModeStr = System.getProperty(DEMO_MODE_PROPERTY);
    if (demoModeStr == null)
    {
      return false;
    } else
    {
      try
      {
        return Boolean.parseBoolean(demoModeStr);
      } catch (Exception e)
      {
        LOG.warning(String.format("Bad '%s' value, '%s'; must be a boolean.",
                DEMO_MODE_PROPERTY, demoModeStr));
        return false;
      }
    }
  }

  //
  // Application Launch method
  //

  /**
   * Entry point for the WebCheckers web application.
   *
   * <p>
   * It wires the application components together.  This is an example
   * of <a href='https://en.wikipedia.org/wiki/Dependency_injection'>Dependency Injection</a>
   * </p>
   *
   * @param args Command line arguments; none expected.
   */
  public static void main(String[] args)
  {
    // initialize Logging
    try{
      ClassLoader classLoader = Application.class.getClassLoader();
      final InputStream logConfig = classLoader.getResourceAsStream("log.properties");
      LogManager.getLogManager().readConfiguration(logConfig);

    }catch(Exception e){
      e.printStackTrace();
      System.err.println("could not initialize log manager because: " + e.getMessage());
    }
    // The application uses FreeMarker templates to generate the HTML
    // responses sent back to the client. This will be the engine processing
    // the templates and associated data.
    final TemplateEngine templateEngine = new FreeMarkerEngine();

    // The application uses Gson to generate JSON representations of Java objects.
    // This should be used by your Ajax Routes to generate JSON for the HTTP
    // response to Ajax requests.
    final Gson gson = new Gson();
    //creates the database manager which keeps track of the data saved
    DatabaseManager databaseManager = new DatabaseManager();
    databaseManager.connect();
    // inject the game center and freemarker engine into web server
    final WebServer webServer = new WebServer(templateEngine, databaseManager);

    // inject web server into application
    final Application app = new Application(webServer);



    // start the application up
    app.initialize();
  }

  //
  // Attributes
  //

  private final WebServer webServer;

  //
  // Constructor
  //

  private Application(final WebServer webServer)
  {
    // validation
    Objects.requireNonNull(webServer, "webServer must not be null");
    //
    this.webServer = webServer;
  }

  //
  // Private methods
  //

  private void initialize()
  {
    LOG.config("Food Logger is initializing.");


    // configure Spark and startup the Jetty web server
    webServer.initialize();

    // other applications might have additional services to configure

    LOG.config("Food Logger initialization complete.");
  }

}
