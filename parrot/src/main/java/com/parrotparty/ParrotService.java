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
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@Path("/parrots")
public class ParrotService implements PropertiesLoader {

    private ObjectMapper mapper;

    private final Logger logger = LogManager.getLogger(this.getClass());

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getJSONForParrots() {

        mapper = new ObjectMapper();

       String results = "";
        try {

            // Convert JSON string from file to Object
            //might not need [] when returning single result?
            Parrot[] result = mapper.readValue(new URL("http://localhost:8080/parrots.json"), Parrot[].class);

            //could also use file but I couldn't get relative path out of it
            //Parrot[] result = mapper.readValue(new File("/home/klyke/student/PartyParrot/parrot/src/main/webapp/parrots.json"), Parrot[].class);
            results = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);

            logger.info(result);


        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.status(200).entity(results).build();
    }

    @GET
    @Path("/{name}")
    @Produces("application/json")
    public Response getJSONForParrot(@PathParam("name") String name) {
        mapper = new ObjectMapper();

        String results = "";
        // default to internal server error response
        Response response = Response.status(500).build();
        Parrot requestedParrot = null;

        // access the parrot data as Objects
        List<Parrot> allParrots = getAllTheParrots();

        // check for the parrot that the user requested
        for (Parrot parrot : allParrots) {
            if (parrot.getName().equals(name)) {
                requestedParrot = parrot;
            }
        }

        if (requestedParrot == null) {
            // send a 404 if the requested parrot doesn't exist
            response = Response.status(404).build();
        } else {
            // send the parrot as json if it exists
            try {
                results = mapper.writeValueAsString(requestedParrot);
                response = Response.status(200).entity(results).build();
            } catch (JsonProcessingException jsonProcessingException) {
                logger.error("A JsonProcessingException occurred when attempting to represent a user as a JSON string.");
            } catch (Exception exception) {
                logger.error("An exception occurred when attempting to represent a user as a JSON string.");
            }
        }
        return response;

        //TODO - Consider space issue:
        // %20 = space
    }

    @GET
    @Path("/categories")
    @Produces("application/json")
    public Response getCategories() {
        String results = "";
        mapper = new ObjectMapper();

        // default to internal server error response
        Response response = Response.status(500).build();

        List<String> categories = new ArrayList<>();
        categories = getAllTheCategories();

        if (categories.size() < 1) {
            // send a 404 if there are no categories
            response = Response.status(404).build();
        } else {
            // send the categories as json
            try {
                results = mapper.writeValueAsString(categories);
                response = Response.status(200).entity(results).build();
            } catch (JsonProcessingException jsonProcessingException) {
                logger.error("A JsonProcessingException occurred when attempting to represent categories as a JSON string.");
            } catch (Exception exception) {
                logger.error("An exception occurred when attempting to represent categories as a JSON string.");
            }
        }
        return response;
    }


    @GET
    //The Java method will produce content identified by the MIME Media type "text/plain"
    @Path("/category/{category}")
    @Produces("application/json")
    public Response getJSONForParrotsByCategory(@PathParam("category") String category) {

        mapper = new ObjectMapper();

        String results = "";
        // default to internal server error response
        Response response = Response.status(500).build();
        ArrayList<Parrot> requestedCategoryParrots = new ArrayList<Parrot>();

        // access the parrot data as Objects
        List<Parrot> allParrots = getAllTheParrots();

        // see if category exists
        for (Parrot parrot : allParrots) {
            if (parrot.getCategory().equals(category)) {
                requestedCategoryParrots.add(parrot);
            }
        }

        if (requestedCategoryParrots.size() < 1) {
            // send a 404 if the requested parrot doesn't exist
            response = Response.status(404).build();
        } else {
            // send the parrot as json if it exists
            try {
                results = mapper.writeValueAsString(requestedCategoryParrots);
                response = Response.status(200).entity(results).build();
            } catch (JsonProcessingException jsonProcessingException) {
                logger.error("A JsonProcessingException occurred when attempting to represent parrots as a JSON string.");
            } catch (Exception exception) {
                logger.error("An exception occurred when attempting to represent a parrot as a JSON string.");
            }
        }
        return response;
    }


    /*

    @POST
    // The Java method will add content to the collection of parrots
    public void createParrot() {

        // Luke will finish this method

    }
    */


    /**
     * Converts JSON data to list of Parrot objects.
     *
     * @return parrot Objects
     */
    private List<Parrot> getAllTheParrots() {
        List<Parrot> allParrots = null;
        Properties properties = getPartyParrotProperties();
        String parrotJsonUrl = properties.getProperty("parrots.data.url");
        mapper = new ObjectMapper();

        try {
            // allParrots = mapper.readValue(new URL("http://localhost:8080/parrots.json"), new TypeReference<List<Parrot>>() {
            allParrots = mapper.readValue(new URL(parrotJsonUrl), new TypeReference<List<Parrot>>() {
        });
            logger.info(allParrots);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allParrots;
    }

    /**
     * Gets a list of distinct categories assigned to parrots in the JSON file.
     *
     * @return a list of all the categories
     */
    private List<String> getAllTheCategories() {
        List<String> categories = new ArrayList<>();
        String category = null;
        List<Parrot> allParrots = getAllTheParrots();

        for (Parrot parrot : allParrots) {
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
            logger.debug("An IOException is occurring while attempting to load the properties file.");
        } catch (Exception exception) {
            logger.debug("An Exception is occurring while attempting to load the "
                    + "properties file.");
        }

        return partyParrotProperties;
    }
}