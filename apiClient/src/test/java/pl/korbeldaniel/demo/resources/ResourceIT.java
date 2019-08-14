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
    private WebTarget staticTarget = client.target("http://localhost:8081");
    private WebTarget apiTarget = client.target("http://localhost:8081/api");

    @Before public void before() {
        apiResource = WebResourceFactory.newResource(ApiResource.class, apiTarget);
    }

    @Test public void testPing() {
        Response result = apiResource.ping();
        assertEquals("pong", result.readEntity(String.class));
    }

    @Test public void testStatic() {
        assertEquals(200, staticTarget.request().get().getStatus());
    }
}
