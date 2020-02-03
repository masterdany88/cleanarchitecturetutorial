package pl.korbeldaniel.demo.resources;

import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.korbeldaniel.demo.BaseIT;
import pl.korbeldaniel.demo.model.UserDto;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Testcontainers
class ResourceIT extends BaseIT {
    private Client client = ClientBuilder.newClient();
    private WebTarget staticTarget;
    private ApiResource apiResource;

    @BeforeEach
    void beforeEach() {
        WebTarget apiTarget = client.target("http://localhost:" + testInstancePort + "/api");
        staticTarget = client.target("http://localhost:" + testInstancePort + "");
        apiResource = WebResourceFactory.newResource(ApiResource.class, apiTarget);
    }

    @Test
    void testPing() {
        Response result = apiResource.ping();
        Assertions.assertEquals("pong", result.readEntity(String.class));
    }

//    @Test
//    void userApiTest() {
//        String name = apiResource.usersResource().getUsers();
//        Assertions.assertEquals("us1, us2, us3", name);
//    }
//
//    @Test
//    void userApiTest2() {
//        Long id = 1L;
//        UserDto userDto = apiResource.usersResource().getUser(1L);
//        Assertions.assertEquals(new UserDto(id, "Test name " + id), userDto);
//    }
//
//    @Test
//    void userRolesApiTest() {
//        String roles = apiResource.usersResource().getUserRolesResource(2L).getAll();
//        Assertions.assertEquals(2L + "=r1, r2, r3", roles);
//    }

    @Test
    void testStatic() {
        Assertions.assertEquals(200, staticTarget.request().get().getStatus());
    }
}
