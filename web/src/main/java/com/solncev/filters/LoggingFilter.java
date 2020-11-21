package com.solncev.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebFilter(filterName = "loggingFilter", urlPatterns = "/*")
public class LoggingFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig filterConfig) {
        this.context = filterConfig.getServletContext();
        this.context.log("LoggingFilter initialized");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        Map<String, String[]> requestParamMap = req.getParameterMap();

        if (requestParamMap != null) {
            requestParamMap.forEach((k, v) -> this.context.log(req.getRemoteAddr()
                    + " : Request Params : {" + k + "=" + Arrays.toString(v) + "}"));
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
