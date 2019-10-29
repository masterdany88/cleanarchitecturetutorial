package pl.korbeldaniel.demo.resources;

import io.swagger.annotations.ApiResponse;
import pl.korbeldaniel.demo.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

 public interface UsersResource {

    @GET String getUsers();

    @GET @Path("{userId}")
    @ApiResponse(code = 200, message = "successful operation", response = User.class)
    User getUser(@PathParam("userId") Long userId);

    @Path("{userId}/roles") UserRolesResource getUserRolesResource(@PathParam("userId") Long userId);
}
