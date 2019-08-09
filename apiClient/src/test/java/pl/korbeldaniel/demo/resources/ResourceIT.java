package pl.korbeldaniel.demo.resources;

import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class ResourceIT {
    private ApiResource apiResource;
    private Client client = ClientBuilder.newClient();
    private WebTarget target = client.target("http://localhost:8081/");

    @Before public void before() {
        apiResource = WebResourceFactory.newResource(ApiResource.class, target);
    }

    @Test public void testPing() {
        Response result = apiResource.ping();
        assertEquals("pong", result.readEntity(String.class));
    }

    @Test public void testStatic() {
        assertEquals(200, target.request().get().getStatus());
    }
}
