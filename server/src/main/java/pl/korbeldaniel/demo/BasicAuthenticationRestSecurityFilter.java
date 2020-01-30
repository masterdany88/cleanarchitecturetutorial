package pl.korbeldaniel.demo;

import org.glassfish.jersey.internal.util.Base64;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.StringTokenizer;

@Provider
public class BasicAuthenticationRestSecurityFilter implements ContainerRequestFilter {

    private static final String BASIC_AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String BASIC_AUTHORIZATION_HEADER_PREFIX = "Basic ";
    private static final String SECURED_URL_PATH_PREFIX = "secured";

    @Override
    public void filter(ContainerRequestContext requestContext) {
        if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PATH_PREFIX)) {
            List<String> authHeaders = requestContext.getHeaders().get(BASIC_AUTHORIZATION_HEADER_KEY);
            if (authHeaders == null) {
                unauthorized(requestContext);
            } else {
                String encodedString = authHeaders.get(0).replaceFirst(BASIC_AUTHORIZATION_HEADER_PREFIX, "");
                String decodeString = Base64.decodeAsString(encodedString);
                StringTokenizer tokenizer = new StringTokenizer(decodeString, ":");
                String username = tokenizer.nextToken();
                String password = tokenizer.nextToken();
                if (!"root".equals(username) && !"password".equals(password)) {
                    unauthorized(requestContext);
                }
            }
        }
    }

    private void unauthorized(ContainerRequestContext requestContext) {
        requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Authorization required").build());
    }
}
