package pl.korbeldaniel.demo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface UsersResource {

    @GET String getUsers();

    @GET @Path("{userId}") String getUser(@PathParam("userId") Long userId);

    @Path("{userId}/roles") UserRolesResource getUserRolesResource(@PathParam("userId") Long userId);
}
