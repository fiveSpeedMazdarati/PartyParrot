package com.parrotparty;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.net.URL;


@Path("/parrot")
public class ParrotService {

    private final Logger logger = LogManager.getLogger(this.getClass());
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getJSONForParrots() {

        ObjectMapper mapper = new ObjectMapper();

        String results = "";
        try {

            // Convert JSON string from file to Object
            //might not need [] when returning single result?
            Results[] result = mapper.readValue(new URL("http://localhost:8080/parrots.json"), Results[].class);

            //could also use file but I couldn't get relative path out of it
            //Results[] result = mapper.readValue(new File("/home/klyke/student/PartyParrot/parrot/src/main/webapp/parrots.json"), Results[].class);
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


}