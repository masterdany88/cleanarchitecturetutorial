package pl.korbeldaniel.demo.resources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class) public class ApiTest {

    private WebTarget client = ClientBuilder.newClient().target("http://localhost:8080/");

    @Test public void apiTest() {
        String name = client.path("ping").request(MediaType.TEXT_PLAIN).get(String.class);
        assertEquals("pong", name);
    }

    @Test public void userApiTest() {
        String name = client.path("users").request(MediaType.TEXT_PLAIN).get(String.class);
        assertEquals("us1, us2, us3", name);
    }

    @Test public void userApiTest2() {
        String name = client.path("users").path("1").request(MediaType.TEXT_PLAIN).get(String.class);
        assertEquals("us1", name);
    }

    @Test public void userRolesApiTest() {
        String name = client.path("users").path("1").path("roles").request(MediaType.TEXT_PLAIN).get(String.class);
        assertEquals("1=r1, r2, r3", name);
    }
}