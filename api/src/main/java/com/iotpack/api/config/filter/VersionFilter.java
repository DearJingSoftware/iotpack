package com.iotpack.api.config.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class VersionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
            IOException,ServletException {
        HttpServletResponse httpServletResponse=(HttpServletResponse)response;
        httpServletResponse.setHeader("Access-Control-Expose-Headers","X-API-VERSION");
        httpServletResponse.setHeader("X-API-VERSION","1.0.0");
        chain.doFilter(request, response);
    }

}