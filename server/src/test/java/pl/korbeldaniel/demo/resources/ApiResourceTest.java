package pl.korbeldaniel.demo.resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

class ApiResourceTest {
    private ApiResource controller = new ApiController();

    @Test void testController() {
        Assertions.assertEquals(Response.Status.OK, controller.ping().getStatusInfo());
        Assertions.assertEquals("pong", controller.ping().getEntity());
    }
}