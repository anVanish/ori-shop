package com.vanish.javaweb.Controllers.Auth;

import com.vanish.javaweb.Entities.User;
import com.vanish.javaweb.Model.UserModel;
import com.vanish.javaweb.Services.User.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignupController", value = "/signup")
public class SignupController extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/user/auth/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String plainPassword = request.getParameter("password");
        String confirmedPassword = request.getParameter("confirmedPassword");

        try{
            User user = userService.signup(email, plainPassword, confirmedPassword);
            UserModel userModel = new UserModel(user);
            request.getSession().setAttribute("user", userModel);

            request.getSession().setAttribute("message", "Signup successfully");
            response.sendRedirect(request.getContextPath() + "/home");
        }catch(Exception e){
            request.getSession().setAttribute("errorMessage", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/signup");
        }

    }
}
