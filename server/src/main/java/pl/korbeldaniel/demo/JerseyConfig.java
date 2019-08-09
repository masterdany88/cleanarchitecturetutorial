package pl.korbeldaniel.demo;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        // scan the resources package for our resources
        packages(getClass().getPackage().getName() + ".resources");
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }

}