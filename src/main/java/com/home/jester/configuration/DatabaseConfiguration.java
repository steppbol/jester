package com.home.jester.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@Configuration
@EnableR2dbcAuditing
@ComponentScan(basePackages = {"com.home.jester"})
public class DatabaseConfiguration {
    private final Environment environment;

    @Autowired
    public DatabaseConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        return new Flyway(Flyway.configure()
                .baselineOnMigrate(false)
                .dataSource(environment.getRequiredProperty("spring.flyway.url"),
                        environment.getRequiredProperty("spring.flyway.user"),
                        environment.getRequiredProperty("spring.flyway.password")));
    }
}
