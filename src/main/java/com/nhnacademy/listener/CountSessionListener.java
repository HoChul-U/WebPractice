package com.nhnacademy.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
@Slf4j
public class CountSessionListener implements HttpSessionListener {

    private int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionCount++;
        log.error("count++ {}", sessionCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionCount--;
        log.error("count-- {}", sessionCount);
    }
}
