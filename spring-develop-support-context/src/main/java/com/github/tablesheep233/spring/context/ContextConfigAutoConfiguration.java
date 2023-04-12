package com.github.tablesheep233.spring.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * The type Context config auto configuration.
 */
@Configuration
public class ContextConfigAutoConfiguration implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationContextHolder.refresh(applicationContext);
    }
}
