package pl.korbeldaniel.demo;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.concurrent.atomic.AtomicBoolean;

@Testcontainers
@ContextConfiguration(initializers = DatabaseContainerTest.Initializer.class)
abstract class DatabaseContainerTest {

    private static final String POSTGRES_VERSION = "postgres:11.5-alpine";

    @Container
    private static final PostgreSQLContainer postgreSqlContainer = new LongLivingPostgreSqlContainer(POSTGRES_VERSION);

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSqlContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSqlContainer.getUsername(),
                    "spring.datasource.password=" + postgreSqlContainer.getPassword(),
                    "spring.flyway.url=" + postgreSqlContainer.getJdbcUrl(),
                    "spring.flyway.user=" + postgreSqlContainer.getUsername(),
                    "spring.flyway.password=" + postgreSqlContainer.getPassword())
                    .applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    /**
     * This PostgreSQL container implementation will survive throughout test classes.
     * Unlike regular @Container PostgreSQLContainer, which will create new container
     * per test class. This let us to maintain Spring context throughout all the test
     * classes and run flyway migration only once per integration tests run.
     * <p>
     * source: https://github.com/testcontainers/testcontainers-java/issues/417#issuecomment-363206633
     */
    static class LongLivingPostgreSqlContainer extends PostgreSQLContainer {
        private static final AtomicBoolean started = new AtomicBoolean(false);

        LongLivingPostgreSqlContainer(String postgresVersion) {
            super(postgresVersion);
        }

        @Override
        public void start() {
            // only allow a single start()
            if (started.compareAndSet(false, true)) {
                super.start();
            }
        }

        @Override
        public void stop() {
            // Do nothing, let the JVM to kill the container after tests will finish
        }
    }
}
