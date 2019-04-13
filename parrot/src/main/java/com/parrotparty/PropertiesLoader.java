package com.parrotparty;

import java.io.IOException;
import java.util.Properties;

/**
 * An interface that loads a properties object
 * using a properties file path as input.
 *
 * @author Eric Knapp
  */
public interface PropertiesLoader {

    /**
     * Loads a properties file into a Properties
     *  instance and returns it.
     *
     * @param propertiesFilePath a path a file on the java classpath list
     * @return a populated Properties instance or an empty Properties instance
     * if the file path was not found
     * @throws Exception if there is a problem loading the properties file
     */
    default Properties loadProperties(String propertiesFilePath) throws Exception {
        // TODO I just used the red lightbulb to switch language to level 8 --- will that mess anything up??
        //  The application seems to work...

        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
            throw ioException;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
        return properties;
    }
}
