package pl.korbeldaniel.demo.resources;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.korbeldaniel.demo.model.UserDto;

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

    @Override public UserDto getUser(Long id) {
        return new UserDto(id, "Test name " + id);
    }

    @Override public UserRolesResource getUserRolesResource(Long id) {
        return userRolesController.withUserId(id);
    }

}
