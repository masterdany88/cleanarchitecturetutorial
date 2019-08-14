package pl.korbeldaniel.demo;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    private static final String RESOURCE_PACKAGE_NAME = JerseyConfig.class.getPackage().getName() + ".resources";

    public JerseyConfig() {
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
        this.registerEndpoints();
        this.configureSwagger2();
    }

    public void configureSwagger2() {
        BeanConfig swaggerConfig = new BeanConfig();
        swaggerConfig.setBasePath("/api");
        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);

        packages(getClass().getPackage().getName(),
                ApiListingResource.class.getPackage().getName());
    }

//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("pl.korbeldaniel.demo.resources"))
//                .paths(PathSelectors.any())
//                .build()
//                .enable(true);
//    }

    private void registerEndpoints() {
        packages(RESOURCE_PACKAGE_NAME);
    }
}
