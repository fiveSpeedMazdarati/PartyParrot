package com.heidiaandahl.controller;

import com.parrotparty.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Properties;

/**
 * Initializer for the Party Parrot application that loads properties on startup.
 *
 * @author Heidi Aandahl
 */

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/startup" },
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void init() {
        // Load properties
        Properties partyParrotProperties = new Properties();

        try {
            partyParrotProperties = loadProperties("/partyparrot.properties");
         } catch (IOException ioException) {
            log("An IOException is occurring while attempting to load the properties file.");
        } catch (Exception exception) {
            log("An Exception is occurring while attempting to load the "
                    + "properties file.");
        }

        ServletContext context = getServletContext();
        context.setAttribute("partyParrotProperties", partyParrotProperties);
    }
}

