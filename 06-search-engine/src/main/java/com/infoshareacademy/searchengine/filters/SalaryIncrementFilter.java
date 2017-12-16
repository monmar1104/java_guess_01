package com.infoshareacademy.searchengine.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(
        filterName = "SalaryIncrementFilter",
        urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name = "salary", value = "100")
        })
public class SalaryIncrementFilter implements Filter{
    private double newSalary;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        newSalary = Double.parseDouble(filterConfig.getInitParameter("salary"));
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String requestSalary = servletRequest.getParameter("salary");
        if(requestSalary==null || requestSalary.isEmpty())
            requestSalary = "0.0";

        double salary = Double.parseDouble(requestSalary);
        if(salary<100.0){
           salary=newSalary;
        }
        servletRequest.setAttribute("salary", salary);
        filterChain.doFilter(servletRequest, servletResponse);

    }
    @Override
    public void destroy() {
        newSalary = 0.0;

    }
}
