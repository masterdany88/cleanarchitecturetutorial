package pl.korbeldaniel.demo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/") public interface ApiResource {

    @GET @Path("ping") Response ping();

    @GET @Path("context") String getContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders);
}
