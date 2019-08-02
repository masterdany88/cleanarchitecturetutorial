package pl.korbeldaniel.demo.resources;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Component
@Scope("request")
public class ApiController implements Api {
    private UsersController usersController;
    @Context ServletContext servletContext;

    @Inject public ApiController(UsersController usersController) {
        this.usersController = usersController;
    }

    @Override public Response ping() {
        return Response.ok("pong").build();
    }

    @Override public UsersController usersResource() {
        return usersController;
    }
}
