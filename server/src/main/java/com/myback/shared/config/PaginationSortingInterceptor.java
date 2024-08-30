package com.myback.shared.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.myback.shared.exceptions.InvalidArgumentException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class PaginationSortingInterceptor implements HandlerInterceptor {

    @Override
    @SuppressWarnings("null")
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws InvalidArgumentException {

        if(!request.getMethod().equals("GET"))
            return true;

        String page = request.getParameter("page");
        String size = request.getParameter("size");
        // String sort = request.getParameter("sort");
        String direction = request.getParameter("dir");

        if (page != null && Integer.parseInt(page) < 0)
            throw new InvalidArgumentException(null, "page", page.toString(), ">=0");

        if (size != null && Integer.parseInt(size) <= 0)
            throw new InvalidArgumentException(null, "size", size.toString(), ">0");

        if (direction != null && !("asc".equalsIgnoreCase(direction) || "desc".equalsIgnoreCase(direction)))
            throw new InvalidArgumentException(null, "dir", direction, "asc|desc");

        return true;
    }
}
