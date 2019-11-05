package pl.korbeldaniel.demo.resources;

import io.swagger.annotations.ApiResponse;
import pl.korbeldaniel.demo.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface UsersResource {

    @GET String getUsers();

    @GET @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponse(code = 200, message = "successful operation", response = User.class)
    User getUser(@PathParam("userId") Long userId);

    @Path("{userId}/roles") UserRolesResource getUserRolesResource(@PathParam("userId") Long userId);
}
