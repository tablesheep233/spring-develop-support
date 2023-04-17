package com.github.tablesheep233.spring.context;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

/**
 * record Spring Boot application main class run listener.
 *
 * @author <a href="mailto:858916094@qq.com">tablesheep233</a>
 */
public class RecordMainApplicationClassRunListener implements SpringApplicationRunListener {

    private static final String APPLICATION_INFO_SOURCE = "application-info-source";

    public static final String MAIN_CLASS = "main-class";

    private final SpringApplication application;

    /**
     * Instantiates a new Record main class run listener.
     *
     * @param application the application
     * @param args        the args
     */
    public RecordMainApplicationClassRunListener(SpringApplication application, String[] args) {
        this.application = application;
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        environment.getPropertySources().addFirst(new MapPropertySource(APPLICATION_INFO_SOURCE, Map.of(MAIN_CLASS, application.getMainApplicationClass())));
    }
}
