package pl.korbeldaniel.demo.resources;

import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import pl.korbeldaniel.demo.model.User;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ResourceIT {
    @LocalServerPort
    private int testInstancePort;
    private Client client = ClientBuilder.newClient();
    private WebTarget staticTarget;
    private WebTarget apiTarget;
    private ApiResource apiResource;

    @BeforeEach
    void beforeEach() {
        apiTarget = client.target("http://localhost:" + testInstancePort + "/api");
        staticTarget = client.target("http://localhost:" + testInstancePort + "");
        apiResource = WebResourceFactory.newResource(ApiResource.class, apiTarget);
    }

    @Test
    void testPing() {
        Response result = apiResource.ping();
        Assertions.assertEquals("pong", result.readEntity(String.class));
    }

    @Test
    void userApiTest() {
        String name = apiResource.usersResource().getUsers();
        Assertions.assertEquals("us1, us2, us3", name);
    }

    @Test
    void userApiTest2() {
        Long id = 1L;
        User user = apiResource.usersResource().getUser(1L);
        Assertions.assertEquals(new User(id, "Test name " + id), user);
    }

    @Test
    void userRolesApiTest() {
        String roles = apiResource.usersResource().getUserRolesResource(2L).getAll();
        Assertions.assertEquals(2L + "=r1, r2, r3", roles);
    }

    @Test
    void testStatic() {
        Assertions.assertEquals(200, staticTarget.request().get().getStatus());
    }
}
