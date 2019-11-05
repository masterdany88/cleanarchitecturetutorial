package pl.korbeldaniel.demo.resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

class ApiResourceTest {
    private ApiController controller = new ApiController(new UsersController(new UserRolesController()));

    @Test void testController() {
        Assertions.assertEquals(Response.Status.OK, controller.ping().getStatusInfo());
        Assertions.assertEquals("pong", controller.ping().getEntity());
    }
}