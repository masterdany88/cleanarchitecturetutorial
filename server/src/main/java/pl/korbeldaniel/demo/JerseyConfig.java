package pl.korbeldaniel.demo;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.Provider;
import java.util.regex.Pattern;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    private Logger LOGGER = LoggerFactory.getLogger(JerseyConfig.class);
    private static final String RESOURCE_PACKAGE_NAME = JerseyConfig.class.getPackage().getName();

    public JerseyConfig() {
        this.registerEndpoints();
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }

    private void registerEndpoints() {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(Provider.class));
        provider.addIncludeFilter(new RegexPatternTypeFilter(Pattern.compile(".*RestController")));
        provider.findCandidateComponents(RESOURCE_PACKAGE_NAME).forEach(beanDefinition -> {
            try {
                LOGGER.info("Jersey registration of {}", beanDefinition.getBeanClassName());
                register(Class.forName(beanDefinition.getBeanClassName()));
            } catch (ClassNotFoundException e) {
                LOGGER.warn("Jersey failed to register {}", beanDefinition.getBeanClassName());
            }
        });
    }
}
