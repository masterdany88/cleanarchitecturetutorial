package pl.korbeldaniel.demo.resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiResourceTest {
    @LocalServerPort
    protected static int testInstancePort;
    private static WebTarget client;

    @BeforeEach void beforeEach() {
        client = ClientBuilder.newClient().target("http://localhost:"+ testInstancePort +"/api");
    }

    @Test void apiTest() {
        String name = client.path("ping").request(MediaType.TEXT_PLAIN).get(String.class);
        Assertions.assertEquals("pong", name);
    }

    @Test void userApiTest() {
        String name = client.path("users").request(MediaType.TEXT_PLAIN).get(String.class);
        Assertions.assertEquals("us1, us2, us3", name);
    }

    @Test void userApiTest2() {
        String name = client.path("users").path("1").request(MediaType.TEXT_PLAIN).get(String.class);
        Assertions.assertEquals("us1", name);
    }

    @Test void userRolesApiTest() {
        String name = client.path("users").path("1").path("roles").request(MediaType.TEXT_PLAIN).get(String.class);
        Assertions.assertEquals("1=r1, r2, r3", name);
    }

    @Test void ok() {

    }
}