package pl.korbeldaniel.demo.resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.korbeldaniel.demo.BaseIT;
import pl.korbeldaniel.demo.model.User;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Testcontainers
class ApiResourceTest extends BaseIT {
    private WebTarget target;

    @BeforeEach void beforeEach() {
        target = ClientBuilder.newClient().target("http://localhost:"+ testInstancePort +"/api");
    }

    @Test void apiTest() {
        String name = target.path("ping").request(MediaType.TEXT_PLAIN).get(String.class);
        Assertions.assertEquals("pong", name);
    }

    @Test void userApiTest() {
        String name = target.path("users").request(MediaType.TEXT_PLAIN).get(String.class);
        Assertions.assertEquals("us1, us2, us3", name);
    }

    @Test void userApiTest2() {
        Long id = 1L;
        User user = target.path("users").path(id.toString()).request(MediaType.APPLICATION_JSON).get(User.class);
        Assertions.assertEquals(new User(id, "Test name " + id), user);
    }

    @Test void userRolesApiTest() {
        String name = target.path("users").path("1").path("roles").request(MediaType.TEXT_PLAIN).get(String.class);
        Assertions.assertEquals("1=r1, r2, r3", name);
    }
}