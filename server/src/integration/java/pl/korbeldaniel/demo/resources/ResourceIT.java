package pl.korbeldaniel.demo.resources;

import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ResourceIT {
    private static ApiResource apiResource;
    private static Client client = ClientBuilder.newClient();
    private WebTarget staticTarget = client.target("http://localhost:8081");
    private static WebTarget apiTarget = client.target("http://localhost:8081/api");

    @BeforeAll
    public static void before() {
        apiResource = WebResourceFactory.newResource(ApiResource.class, apiTarget);
    }

    @Test
    public void testPing() {
        Response result = apiResource.ping();
        Assertions.assertEquals("pong", result.readEntity(String.class));
    }

    @Test public void testStatic() {
        Assertions.assertEquals(200, staticTarget.request().get().getStatus());
    }

    @Test public void testStatic2() {
        Assertions.assertEquals(200, staticTarget.request().get().getStatus());
    }
}
