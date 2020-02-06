package pl.korbeldaniel.demo.resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.korbeldaniel.demo.model.UserDto;

import static org.junit.Assert.fail;

class UsersResourceTest {
    private Long userId = 2L;
    private UsersResource controller = new UsersRestController(new UserRolesRestController());

    @Test void testGetUsers() {
        Assertions.assertEquals("us1, us2, us3", controller.getUsers());
    }

    @Test void testGetUserById() {
        Assertions.assertEquals(new UserDto(userId, "Test name " + userId), controller.getUser(userId));
    }

    @Test void testGetUserRolesResource() {
        //controller.getUserRolesResource(userId);
        //it should be tested on IT
    }
}