package com.github.tablesheep233.spring.context;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * The type Context support auto configuration.
 *
 * @author tablesheep233
 */
@AutoConfiguration
public class ContextSupportAutoConfiguration implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationContextHolder.refresh(applicationContext);
    }
}
