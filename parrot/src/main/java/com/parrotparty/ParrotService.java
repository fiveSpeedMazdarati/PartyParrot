package com.parrotparty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/parrot")
public class ParrotService {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    @Path("/{param}")
    public Response getMessage(@PathParam("param") String msg) {

        String output = "Parrot " + msg;
        return Response.status(200).entity(output).build();
    }

}