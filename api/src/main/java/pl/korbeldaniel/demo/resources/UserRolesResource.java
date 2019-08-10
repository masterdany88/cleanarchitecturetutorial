package pl.korbeldaniel.demo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface UserRolesResource {

    @GET String getAll();

    @GET @Path("{userRoleId}") String getById(@PathParam("userRoleId") Long userRoleId);
}
