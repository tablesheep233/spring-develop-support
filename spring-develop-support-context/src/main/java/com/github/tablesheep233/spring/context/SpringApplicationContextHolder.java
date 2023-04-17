package com.github.tablesheep233.spring.context;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextException;

/**
 * The type Spring application context holder.
 *
 * @author tablesheep233
 */
public class SpringApplicationContextHolder {

    private static ApplicationContext APPLICATION_CONTEXT;
    private SpringApplicationContextHolder() {
    }

    /**
     * Refresh.
     *
     * @param applicationContext the application context
     * @throws BeansException the beans exception
     */
    public static void refresh(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext == null) {
            throw new ApplicationContextException(
                    "Invalid application context: needs to be of type [" + ApplicationContext.class.getName() + "]");
        }
        SpringApplicationContextHolder.APPLICATION_CONTEXT = applicationContext;
        LogFactory.getLog(SpringApplicationContextHolder.class).info("SpringApplicationContextHolder is ready");
    }

    /**
     * Gets application context.
     *
     * @return the application context
     */
    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }

    /**
     * Gets bean.
     *
     * @param beanName the bean name
     * @return the bean
     */
    public static Object getBean(String beanName) {
        return APPLICATION_CONTEXT.getBean(beanName);
    }

    /**
     * Gets bean.
     *
     * @param <T>   the type parameter
     * @param clazz the clazz
     * @return the bean
     */
    public static <T> T getBean(Class<T> clazz) {
        return APPLICATION_CONTEXT.getBean(clazz);
    }

    /**
     * Publish event.
     *
     * @param event the event
     */
    public static void publishEvent(Object event) {
        APPLICATION_CONTEXT.publishEvent(event);
    }

}
