package com.javazk.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/demoApi")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface IDemoApi {
	@Path("/demo")
	@GET
	public String demo(String param) ;
}
