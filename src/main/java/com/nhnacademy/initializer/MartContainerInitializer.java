package com.nhnacademy.initializer;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@Slf4j
@HandlesTypes({
        javax.servlet.http.HttpServlet.class,
        javax.servlet.Filter.class,
        javax.servlet.ServletContextListener.class,
        javax.servlet.http.HttpSessionListener.class
})
public class MartContainerInitializer implements ServletContainerInitializer {
    private String value;
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("onion", "2");
        servletContext.setInitParameter("eggs", "5");
        servletContext.setInitParameter("welshOnion", "10");
        servletContext.setInitParameter("apple", "20");
        servletContext.setInitParameter("counter", "counter.dat");
    }
}
