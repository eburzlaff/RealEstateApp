package com.rsproperties.controller;

import com.rsproperties.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/applicationStartup" },
        loadOnStartup = 1
)
/**
 * This servlet is the startup for the application.
 *
 * @author Eduardo Burzlaff
 */
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {

    public Properties properties;

    // Cognito User Pool Info
    public static String CLIENT_ID;

    public static String CLIENT_SECRET;

    public static String OAUTH_URL;

    public static String LOGIN_URL;

    public static String SIGNUP_URL;

    public static String REDIRECT_URL;

    public static String POOL_ID;

    public static String REGION;

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        try {
            properties = loadProperties("/cognito.properties");
            CLIENT_ID = properties.getProperty("client.id");
            CLIENT_SECRET = properties.getProperty("client.secret");
            OAUTH_URL = properties.getProperty("oauthURL");
            LOGIN_URL = properties.getProperty("loginURL");
            SIGNUP_URL = properties.getProperty("signupURL");
            REDIRECT_URL = properties.getProperty("redirectURL");
            REGION = properties.getProperty("region");
            POOL_ID = properties.getProperty("poolId");
        } catch (IOException ioException) {
            logger.error("Cannot load properties..." + ioException.getMessage(), ioException);
        } catch (Exception e) {
            logger.error("Error loading properties" + e.getMessage(), e);
        }

        context.setAttribute("clientId", CLIENT_ID);
        context.setAttribute("clientSecret", CLIENT_SECRET);
        context.setAttribute("oAuthURL", OAUTH_URL);
        context.setAttribute("loginURL", LOGIN_URL);
        context.setAttribute("signupURL", SIGNUP_URL);
        context.setAttribute("redirectURL", REDIRECT_URL);
        context.setAttribute("region", REGION);
        context.setAttribute("poolId", POOL_ID);

    }



}
