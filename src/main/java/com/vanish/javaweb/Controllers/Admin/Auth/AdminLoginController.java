package com.vanish.javaweb.Controllers.Admin.Auth;

import com.vanish.javaweb.Entities.User;
import com.vanish.javaweb.Model.UserModel;
import com.vanish.javaweb.Services.User.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminLoginController", value = "/admin/login")
public class AdminLoginController  extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/admin/auth/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = userService.login(email, password);
            if (!user.getIsAdmin()){
                throw new Exception("Required Admin authorization");
            }

            UserModel userModel = new UserModel(user);
            request.getSession().setAttribute("user", userModel);

            request.getSession().setAttribute("message", "Login successfully");
            response.sendRedirect(request.getContextPath() + "/admin");
        } catch (Exception e) {
            request.getSession().setAttribute("errorMessage", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/admin/login");
        }
    }
}
