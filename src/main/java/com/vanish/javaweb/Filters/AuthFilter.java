package com.vanish.javaweb.Filters;

import com.vanish.javaweb.Entities.User;
import com.vanish.javaweb.Model.UserModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter("/*")
public class AuthFilter implements Filter {

    // Paths that require login
    private final List<String> protectedPaths = Arrays.asList(
            "/me", "/checkout", "/cart", "/order"
    );

    // Paths that require admin role
    private final List<String> adminPaths = Arrays.asList(
            "/admin", "/admin/categories", "/admin/products", "/admin/users", "/admin/orders"
    );

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String path = req.getRequestURI().substring(req.getContextPath().length());

        //redirect to home page
        if (path.equals("/")) {
            res.sendRedirect(req.getContextPath() + "/home");
            return;
        }

        //exclude paths
        List<String> publicPaths = Arrays.asList(
                "/admin/login", "/assets", "/css", "/js", "/images"
        );
        if (publicPaths.stream().anyMatch(path::startsWith)) {
            chain.doFilter(request, response);
            return;
        }

        //check login & admin
        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        boolean isAdmin = false;

        if (loggedIn){
            UserModel user  = (UserModel) session.getAttribute("user");
            isAdmin = user.isAdmin();
        }

        //protected paths require login & not admin
        if (protectedPaths.stream().anyMatch(path::startsWith)) {
            if (!loggedIn || isAdmin) {
                req.getSession().setAttribute("errorMessage", "Please login to continue");
                res.sendRedirect(req.getContextPath() + "/login");
                return;
            }
        }

        //admin paths require login an admin
        if (adminPaths.stream().anyMatch(path::startsWith)) {
            if (!loggedIn || !isAdmin) {
                req.getSession().setAttribute("errorMessage", "Please login as Admin");
                res.sendRedirect(req.getContextPath() + "/admin/login");
                return;
            }
        }

        //as normal
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
