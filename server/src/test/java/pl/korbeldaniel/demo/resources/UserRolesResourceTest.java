package pl.korbeldaniel.demo.resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserRolesResourceTest {
    private Long userId = 2L;
    private Long userRoleId = 3L;
    private UserRolesResource controller = new UserRolesRestController().withUserId(userId);

    @Test void testGetById() {
        Assertions.assertEquals("userId " + userId + "roleId=" + userRoleId, controller.getById(userRoleId));
    }

    @Test void testGetAll() {
        Assertions.assertEquals( userId + "=r1, r2, r3", controller.getAll());
    }

}