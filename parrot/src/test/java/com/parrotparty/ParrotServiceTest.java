package com.parrotparty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * The type Parrot service test.
 */
public class ParrotServiceTest implements PropertiesLoader {

    ParrotService testService;
    List<Parrot> testParrots;
    Properties testProperties;
    String parrotJsonUrl;

    private final Logger logger = LogManager.getLogger(this.getClass());
    // ERROR StatusLogger No log4j2 configuration file found. Using default configuration: logging only errors to the console. Set system property 'log4j2.debug' to show Log4j2 internal initialization logging.

    /**
     * Populates instance variables in order to set up for tests.
     *
     * @throws IOException the io exception
     */
    @BeforeEach
    public void setUp() throws IOException {
        testService = new ParrotService();
        testParrots  = new ArrayList<>();
        testProperties = new Properties();
        try {
            testProperties = loadProperties("/partyParrotTest.properties");
        } catch (IOException ioException) {
            logger.debug("An IOException is occurring while attempting to load the properties file.");
        } catch (Exception exception) {
            logger.debug("An Exception is occurring while attempting to load the "
            + "properties file.");
        }

        parrotJsonUrl = testProperties.getProperty("parrots.data.url");
    }


    /**
     * Tests the getAllTheParrots method.
     *
     * @throws Exception the exception
     */
    @Test
    public void getAllTheParrotsSuccess() throws Exception {
        // get the list of parrots from the test JSON file
        testParrots = testService.getAllTheParrots(parrotJsonUrl);

        // expected: 10 parrots
        assertEquals(10, testParrots.size());
    }

    /**
     * Tests the getAllTheCategories method.
     *
     * @throws Exception the exception
     */
    @Test
    public void getAllTheCategoriesSuccess() throws Exception {
        // get the list of parrots from the test JSON file
        testParrots = testService.getAllTheParrots(parrotJsonUrl);

        List<String> testCategories = testService.getAllTheCategories(testParrots);

        // expected categories: traditional, technology, hip
        assertEquals(3, testCategories.size());
        assertTrue(testCategories.contains("traditional"));
        assertTrue(testCategories.contains("technology"));
        assertTrue(testCategories.contains("hip"));
    }
}
