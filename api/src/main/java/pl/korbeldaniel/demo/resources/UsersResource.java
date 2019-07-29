package pl.korbeldaniel.demo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface UsersResource {

    @GET String getUsers();

    @GET @Path("{id}") String getUser(@PathParam("id") Long id);

    @Path("{id}/roles") UserRolesResource getUserRolesResource(@PathParam("id") Long id);
}
