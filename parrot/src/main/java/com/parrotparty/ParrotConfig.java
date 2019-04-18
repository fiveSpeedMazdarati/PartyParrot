package com.parrotparty;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * The configuration for the Party Parrot Application.  Declares the root resource and provider class(es).
 */
@ApplicationPath("/services")
public class ParrotConfig extends Application {

    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(ParrotService.class );
        return h;
    }
}