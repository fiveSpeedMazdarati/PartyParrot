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


@Path("/parrots")
public class ParrotService implements PropertiesLoader {

    private ObjectMapper mapper;
    // todo - can we make the properties a final class variable, pulled out of each method? Or does that not work b/c we need to call loader?

    private final Logger logger = LogManager.getLogger(this.getClass());

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getJSONForParrots() {

        mapper = new ObjectMapper();
        Properties parrotProperties = getPartyParrotProperties();

       String results = "";
        try {

            // Convert JSON string from file to Object
            //might not need [] when returning single result?
            Parrot[] result = mapper.readValue(new File(parrotProperties.getProperty("parrots.data.url")), Parrot[].class);

            //could also use file but I couldn't get relative path out of it
            //Parrot[] result = mapper.readValue(new File("/home/klyke/student/PartyParrot/parrot/src/main/webapp/parrots.json"), Parrot[].class);
            results = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);

            logger.info(result);
        } catch (JsonGenerationException e) {
            logger.error(e.getMessage());
        } catch (JsonMappingException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (Exception e){
            logger.error(e.getMessage());
        }

        return Response.status(200).entity(results).build();
    }

    @GET
    @Path("/{name}")
    @Produces("application/json")
    public Response getJSONForParrot(@PathParam("name") String name) {
        // set up variables
        String results = "";
        Properties properties = null;
        String parrotJsonUrl = "";
        Parrot requestedParrot = null;

        mapper = new ObjectMapper();

        // default to internal server error response
        Response response = Response.status(500).build();

         // get the json data at the location specified by the properties file
        properties = getPartyParrotProperties();
        parrotJsonUrl = properties.getProperty("parrots.data.url");

        // access the parrot data as Objects
        List<Parrot> allParrots = getAllTheParrots(parrotJsonUrl);

        // check for the parrot that the user requested
        for (Parrot parrot : allParrots) {
            if (parrot.getName().equals(name)) {
                requestedParrot = parrot;
            }
        }

        // create the response
        if (requestedParrot == null) {
            // send a 404 if the requested parrot doesn't exist
            response = Response.status(404).build();
        } else {
            // send the parrot as json if it exists
            try {
                results = mapper.writeValueAsString(requestedParrot);
                response = Response.status(200).entity(results).build();
            } catch (JsonProcessingException jsonProcessingException) {
                logger.error(jsonProcessingException.getMessage());
            } catch (Exception exception) {
                logger.error(exception.getMessage());
            }
        }
        return response;

    }

    @GET
    @Path("/categories")
    @Produces("application/json")
    public Response getCategories() {
        // set up variables
        String results = "";
        Properties properties = null;
        String parrotJsonUrl = "";

        mapper = new ObjectMapper();

        // default to internal server error response
        Response response = Response.status(500).build();

        // get the json data at the location specified by the properties file
        properties = getPartyParrotProperties();
        parrotJsonUrl = properties.getProperty("parrots.data.url");

        // get the parrot objects from the json and find their categories
        List<String> categories = new ArrayList<>();
        List<Parrot> parrots = getAllTheParrots(parrotJsonUrl);
        categories = getAllTheCategories(parrots);

        // create the appropriate response
        if (categories.size() < 1) {
            // send a 404 if there are no categories
            response = Response.status(404).build();
        } else {
            // send the categories as json
            try {
                results = mapper.writeValueAsString(categories);
                response = Response.status(200).entity(results).build();
            } catch (JsonProcessingException jsonProcessingException) {
                logger.error(jsonProcessingException.getMessage());
            } catch (Exception exception) {
                logger.error(exception.getMessage());
            }
        }

        return response;
    }


    @GET
    //The Java method will produce content identified by the MIME Media type "text/plain"
    @Path("/categorized-parrots/{category}")
    @Produces("application/json")
    public Response getJSONForParrotsByCategory(@PathParam("category") String category) {

        mapper = new ObjectMapper();
        Properties properties = null;
        String results = "";
        String parrotJsonUrl = "";

        // default to internal server error response
        Response response = Response.status(500).build();
        ArrayList<Parrot> requestedCategoryParrots = new ArrayList<Parrot>();

        // get the json data at the location specified by the properties file
        properties = getPartyParrotProperties();
        parrotJsonUrl = properties.getProperty("parrots.data.url");

        // access the parrot data as Objects
        List<Parrot> allParrots = getAllTheParrots(parrotJsonUrl);

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
                logger.error(jsonProcessingException.getMessage());
            } catch (Exception exception) {
                logger.error(exception.getMessage());
            }
        }
        return response;
    }


    /**
     * Creates and stores a new parrot
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
     * Utility method to create a parrot and send back a response
     * @param parrot the parrot to add to the collection
     * @return the response to send to the web service consumer
     */
    private Response createParrotResponse(Parrot parrot) {
        String parrotJsonUrl = "";

        Response response = Response.noContent().build();
        Properties partyParrotProperties = getPartyParrotProperties();

        // get the json data at the location specified by the properties file
        parrotJsonUrl = partyParrotProperties.getProperty("parrots.data.url"); // todo (?) could use var in try block too

        List<Parrot> allTheParrots = getAllTheParrots(parrotJsonUrl);

        allTheParrots.add(parrot);

        mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(partyParrotProperties.getProperty("parrots.data.url")), allTheParrots);
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
     * @param parrotJsonUrl
     * @return
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
}