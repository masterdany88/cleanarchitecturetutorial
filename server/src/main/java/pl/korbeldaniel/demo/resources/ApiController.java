package pl.korbeldaniel.demo.resources;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@Component
@Scope("request")
public class ApiController extends Application implements Api {
    private UsersController usersController;

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
