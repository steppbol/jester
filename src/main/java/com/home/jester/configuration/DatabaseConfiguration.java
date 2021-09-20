package com.home.jester.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@Configuration
@EnableR2dbcAuditing
@ComponentScan(basePackages = {"com.home.jester"})
public class DatabaseConfiguration {
}
