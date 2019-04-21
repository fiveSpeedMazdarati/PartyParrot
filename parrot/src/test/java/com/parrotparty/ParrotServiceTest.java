package com.parrotparty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
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

    /**
     *  Tests the getParrotJsonUrl method.
     *
     * @throws Exception the exception
     */
    @Test
    public void getParrotJsonUrlSuccess() throws Exception {
        // should get the real url, not the test one
        String testUrl = testService.getParrotJsonUrl();

        assertEquals("/var/lib/parrot-service/stuff.json", testUrl);
    }

    /**
     * Tests the ability of getParrotDataResponse to produce a status 200 response for a list of parrots.
     *
     * @throws Exception the exception
     */
    @Test
    public void getParrotDataResponse200ParrotsSuccess() throws Exception {
        // get the list of parrots from the test JSON file
        testParrots = testService.getAllTheParrots(parrotJsonUrl);

        boolean testBoolean = true;

        Response testResponse = (Response) testService.getParrotDataResponse(testBoolean, testParrots);
        assertEquals(200, testResponse.getStatus());
    }

    /**
     * Tests the ability of getParrotDataResponse to produce a status 404 response for an empty list of parrots.
     *
     * @throws Exception the exception
     */
    @Test
    public void getParrotDataResponse404ParrotsSuccess() throws Exception {
        boolean testBoolean = false;

        Response testResponse = (Response) testService.getParrotDataResponse(testBoolean, testParrots);
        assertEquals(404, testResponse.getStatus());
    }

    /**
     * Tests the ability of getParrotDataResponse to produce a status 200 response for a list of categories.
     *
     * @throws Exception the exception
     */
    @Test
    public void getParrotDataResponse200CategoriesSuccess() throws Exception {
        // get the list of parrots from the test JSON file
        testParrots = testService.getAllTheParrots(parrotJsonUrl);

        List<String> testCategories = testService.getAllTheCategories(testParrots);

        boolean testBoolean = true;

        Response testResponse = (Response) testService.getParrotDataResponse(testBoolean, testCategories);
        assertEquals(200, testResponse.getStatus());
    }

    /**
     * Tests the ability of getParrotDataResponse to produce a status 404 response for an empty list of categories.
     *
     * @throws Exception the exception
     */
    @Test
    public void getParrotDataResponse404CategoriesSuccess() throws Exception {
        boolean testBoolean = false;

        List<String> testCategories = new ArrayList<String>();

        Response testResponse = (Response) testService.getParrotDataResponse(testBoolean, testCategories);
        assertEquals(404, testResponse.getStatus());
    }


    /**
     * Tests the ability of getParrotDataResponse to produce a status 200 response for a single parrot
     *
     * @throws Exception the exception
     */
    @Test
    public void getParrotDataResponse200ParrotSuccess() throws Exception {
        // get the list of parrots from the test JSON file
        testParrots = testService.getAllTheParrots(parrotJsonUrl);
        Parrot testParrot = testParrots.get(0);

        boolean testBoolean = true;

        Response testResponse = (Response) testService.getParrotDataResponse(testBoolean, testParrot);
        assertEquals(200, testResponse.getStatus());
    }


    /**
     * Tests the ability of getParrotDataResponse to produce a status 404 response for null parrot.
     *
     * @throws Exception the exception
     */
    @Test
    public void getParrotDataResponse404ParrotSuccess() throws Exception {
        Parrot testParrot = null;

        boolean testBoolean = false;

        Response testResponse = (Response) testService.getParrotDataResponse(testBoolean, testParrot);
        assertEquals(404, testResponse.getStatus());
    }


}
