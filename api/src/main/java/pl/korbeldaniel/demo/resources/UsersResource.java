package pl.korbeldaniel.demo.resources;

import io.swagger.annotations.ApiResponse;
import pl.korbeldaniel.demo.model.UserDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface UsersResource {

    @GET String getUsers();

    @GET @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponse(code = 200, message = "successful operation", response = UserDto.class)
    UserDto getUser(@PathParam("userId") Long userId);

    @Path("{userId}/roles") UserRolesResource getUserRolesResource(@PathParam("userId") Long userId);
}
