package com.javazk.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * @author yan
 */
@Path("demoApi")
@Produces({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})
public interface DemoApi {

    @GET
    @Path("/demo/{phone}/")
    String Demo(@PathParam("phone") String phone);
}
