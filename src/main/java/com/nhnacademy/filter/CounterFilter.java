package com.nhnacademy.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.util.Optional;

@Slf4j
@WebFilter(filterName = "counterFilter",value = {"/foods" ,"/cart"})
public class CounterFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext servletContext = servletRequest.getServletContext();
        String fileName ="C:\\Users\\koohh\\Study\\git_fork\\WebPractice\\src\\main\\resources\\"+servletContext.getInitParameter("counter");
        System.out.println(fileName);
        Integer counter = null;
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            line = reader.readLine();
        } catch (IOException e) {
            log.error("", e);
        }
        log.error(line);
        counter = Integer.parseInt(line);
        counter = Optional.ofNullable(counter).orElse(0);
        counter +=1;
        log.error("Counter :"+counter);
        filterChain.doFilter(servletRequest,servletResponse);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(counter.toString());
        }catch (IOException e) {
            log.error("", e);
        }
    }
}
