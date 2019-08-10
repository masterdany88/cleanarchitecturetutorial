package pl.korbeldaniel.demo;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    private static final String RESOURCE_PACKGAE_NAME = JerseyConfig.class.getPackage().getName() + ".resources";

    public JerseyConfig() {
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
        this.registerEndpoints();
        this.configureSwagger();
    }

    private void registerEndpoints() {
        packages(RESOURCE_PACKGAE_NAME);
    }

    private void configureSwagger() {
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);
        BeanConfig config = new BeanConfig();
//        config.setConfigId("spring-boot-jaxrs-swagger");
        config.setTitle("Demo API");
        config.setVersion("v1");
        config.setBasePath("/");
        config.setResourcePackage(RESOURCE_PACKGAE_NAME);
        config.setPrettyPrint(true);
        config.setScan(true);
        // http://localhost:8081/swagger.json
    }
}
