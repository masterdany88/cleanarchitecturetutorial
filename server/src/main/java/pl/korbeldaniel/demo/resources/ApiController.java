package pl.korbeldaniel.demo.resources;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Component
@Scope("request")
public class ApiController implements ApiResource {

    @Override
    public Response ping() {
        return Response.ok("pong").build();
    }

    @Override
    public String getContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        return uriInfo.toString() +
                httpHeaders.toString();
    }
}
