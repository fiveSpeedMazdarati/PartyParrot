package com.parrotparty;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * A service that processes requests to get information on Party Parrots or to add new Party Parrots to the collection.
 */
@Path("/parrots")
public class ParrotService implements PropertiesLoader {

    private ObjectMapper mapper;

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Processes GET requests for all the Party Parrots in the collection and returns the data as json.
     *
     * @return a response with json data on all the Party Parrots in the collection
     */
    @GET
    @Produces("application/json")
    public Response getJSONForParrots() {
        // set up variables with defaults
        List<Parrot> allParrots = new ArrayList<>();
        boolean hasData = false;

        // get the url of the parrot data
        String parrotJsonUrl = getParrotJsonUrl();

        // access the parrot data as Objects
        allParrots = getAllTheParrots(parrotJsonUrl);

        // check for data
        if (allParrots.size() > 0) {
            hasData = true;
        }

        // get and return response
        return getParrotDataResponse(hasData, allParrots);
    }


    /**
     * Processes GET requests for a single Party Parrot, searched by name, and returns the data as json.
     *
     * @param name the name of the Party Parrot
     * @return a response with the json data for the parrot
     */
    @GET
    @Path("/{name}")
    @Produces("application/json")
    public Response getJSONForParrot(@PathParam("name") String name) {
        // set up variables with defaults
        Parrot requestedParrot = null;
        boolean hasData = false;

        // get the url of the parrot data
        String parrotJsonUrl = getParrotJsonUrl();

        // access the parrot data as Objects
        List<Parrot> allParrots = getAllTheParrots(parrotJsonUrl);

        // check for the parrot that the user requested
        for (Parrot parrot : allParrots) {
            if (parrot.getName().equals(name)) {
                requestedParrot = parrot;
            }
        }

        // check for data
        if (requestedParrot != null) {
            hasData = true;
        }

        // get and return response
        return getParrotDataResponse(hasData, requestedParrot);
    }

    /**
     * Processes GET requests for all the categories that Party Parrots in the collection belong to.
     *
     * @return a response with all the categories
     */
    @GET
    @Path("/categories")
    @Produces("application/json")
    public Response getCategories() {
        // set up variables with defaults
        List<String> categories = new ArrayList<>();
        boolean hasData = false;

        // get the json data at the location specified by the properties file
        String parrotJsonUrl = getParrotJsonUrl();

        // get the parrot objects from the json and find their categories
        List<Parrot> parrots = getAllTheParrots(parrotJsonUrl);
        categories = getAllTheCategories(parrots);

        // check for data
        if (categories.size() > 0) {
            hasData = true;
        }

        // get and return response
        return getParrotDataResponse(hasData, categories);
    }


    /**
     * Processes GET requests for all the Party Parrots that belong to a specific category and returns their data as json.
     *
     * @param category the category
     * @return the json for parrots in the category
     */
    @GET
    //The Java method will produce content identified by the MIME Media type "text/plain"
    @Path("/categories/{category}")
    @Produces("application/json")
    public Response getJSONForParrotsByCategory(@PathParam("category") String category) {
        // set up variables with defaults
       // List<Parrot> requestedCategoryParrots = new ArrayList<Parrot>();
        boolean hasData = false;

        // get the json data at the location specified by the properties file
        String parrotJsonUrl = getParrotJsonUrl();
       // String parrotJsonUrl = "http://52.14.41.110:8080/PartyParrot4Ever/services/parrots";

        // access the parrot data as Objects
        List<Parrot> allParrots = getAllTheParrots(parrotJsonUrl);
        //requestedCategoryParrots = getAllTheParrots(parrotJsonUrl);
        List<Parrot> requestedCategoryParrots = new ArrayList<Parrot>();

        // see if category exists
        for (Parrot parrot : allParrots) {
            String parrotCategory = parrot.getCategory();
            if (category.equals(parrotCategory)) {
                requestedCategoryParrots.add(parrot);
            }
        }

        // check for data
       if (requestedCategoryParrots.size() > 0) {
            hasData = true;
       }
        // get and return response
        return getParrotDataResponse(hasData, requestedCategoryParrots);
    }


    /**
     * Creates and stores a new parrot
     *
     * @param name     the name
     * @param link     the link
     * @param hdLink   the hd link
     * @param category the category
     * @return the response
     */
    @POST
    @Path("new-parrots/{name}/{link}/{hdLink}/{category}")
    @Consumes("text/plain")
    public Response createParrot(@PathParam("name") String name
                            , @PathParam("link") String link
                            , @PathParam("hdLink") String hdLink
                            , @PathParam("category") String category ) {

        return createParrotResponse(new Parrot(name, link, hdLink, category));
    }

    /**
     * Creates and stores a new parrot consuming form params
     *
     * @param name     the name
     * @param link     the link
     * @param hdLink   the hd link
     * @param category the category
     * @return the response
     */
    @POST
    @Path("new-parrots/")
    @Consumes("application/x-www-form-urlencoded")
    public Response createParrotUsingFormParams(@FormParam("name") String name
            , @FormParam("link") String link
            , @FormParam("hdLink") String hdLink
            , @FormParam("category") String category ) {

        return createParrotResponse(new Parrot(name, link, hdLink, category));
    }

    /**
     * Creates a json response with the appropriate status for get requests.
     *
     * @param haveData whether there is data matching the request
     * @param data     the data matching the request
     * @return the parrot data response
     */
    public Response getParrotDataResponse(boolean haveData, Object data) {
        String results = "";

        mapper = new ObjectMapper();

        // default to internal server error response
        Response response = Response.status(500).build();

        if (!haveData) {
            response = Response.status(404).build();
        } else {
            // send the parrot as json if it exists
            try {
                results = mapper.writeValueAsString(data);
                response = Response.status(200).entity(results).build();
            } catch (JsonProcessingException jsonProcessingException) {
                logger.error(jsonProcessingException.getMessage());
            } catch (Exception exception) {
                logger.error(exception.getMessage());
            }
        }

        return response;
    }

    /**
     * Utility method to create a parrot and send back a response
     * @param parrot the parrot to add to the collection
     * @return the response to send to the web service consumer
     */
    private Response createParrotResponse(Parrot parrot) {
        String parrotJsonUrl = "";

        Response response = Response.noContent().build();

        // get the json data at the location specified by the properties file
        parrotJsonUrl = getParrotJsonUrl();

        List<Parrot> allTheParrots = getAllTheParrots(parrotJsonUrl);

        allTheParrots.add(parrot);

        mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(parrotJsonUrl), allTheParrots);
            // return a success code and the number of parrots added
            response = Response.status(200).entity("1").build();
        } catch(JsonGenerationException json) {
            logger.error(json.getMessage());
            response = Response.status(400).build();
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            response = Response.status(608).build();
        }
        return response;

    }

    /**
     * Converts JSON data to list of Parrot objects.
     *
     * @param parrotJsonUrl the parrot json url
     * @return all the parrots
     */
    public List<Parrot> getAllTheParrots(String parrotJsonUrl) {
        List<Parrot> allParrots = null;

        mapper = new ObjectMapper();

        try {
            allParrots = mapper.readValue(new File(parrotJsonUrl), new TypeReference<List<Parrot>>() {
            });
            logger.info(allParrots);
        } catch (JsonGenerationException jsonGenerationException) {
            logger.error(jsonGenerationException.getMessage());
        } catch (JsonMappingException jsonMappingException) {
            logger.error(jsonMappingException.getMessage());
        } catch (IOException ioException) {
            logger.error(ioException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }

        return allParrots;
    }

    /**
     * Gets a list of distinct categories assigned to parrots in the JSON file.
     *
     * @param parrots list of parrots
     * @return list of categories assigned to parrots
     */
    public List<String> getAllTheCategories(List<Parrot> parrots) {
        List<String> categories = new ArrayList<>();
        String category = null;

        for (Parrot parrot : parrots) {
            category = parrot.getCategory();
            if ((category != null) && !categories.contains(category)) {
                categories.add(category);
            }
        }

        return categories;
    }

    /**
     * Loads properties for the application
     *
     * @return properties for the application
     */
    private Properties getPartyParrotProperties() {
        // Load properties
        Properties partyParrotProperties = new Properties();

        try {
            partyParrotProperties = loadProperties("/partyparrot.properties");
        } catch (IOException ioException) {
            logger.error(ioException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }

        return partyParrotProperties;
    }

    /**
     * Gets the url of the file with the parrot data
     *
     * @return string with the url of the file with the parrot data
     */
    public String getParrotJsonUrl() {
        String parrotJsonUrl = "";
        Properties properties = getPartyParrotProperties();
        parrotJsonUrl = properties.getProperty("parrots.data.url");
        return parrotJsonUrl;
    }

}