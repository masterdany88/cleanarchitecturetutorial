package pl.korbeldaniel.demo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api") public interface Api {

    @GET @Path("ping") Response ping();

    @Path("users") UsersResource usersResource();
}
