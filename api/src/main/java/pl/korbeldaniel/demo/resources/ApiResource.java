package pl.korbeldaniel.demo.resources;


import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Api(value = "API")
@Path("/") public interface ApiResource {

    @GET @Path("ping") Response ping();

    @Path("users") UsersResource usersResource();
}
