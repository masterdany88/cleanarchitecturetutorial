package pl.korbeldaniel.demo.resources;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
@Scope("request")
public class UsersController implements UsersResource {
    private final UserRolesController userRolesController;

    @Inject public UsersController(UserRolesController userRolesController) {
        this.userRolesController = userRolesController;
    }

    @Override public String getUsers() {
        return "us1, us2, us3";
    }

    @Override public String getUser(Long id) {
        return "us" + id;
    }

    @Override public UserRolesResource getUserRolesResource(Long id) {
        return userRolesController.withUserId(id);
    }

}
