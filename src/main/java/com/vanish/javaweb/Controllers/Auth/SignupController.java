package com.vanish.javaweb.Controllers.Auth;

import com.vanish.javaweb.Entities.User;
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

        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String plainPassword = request.getParameter("password");
        String confirmedPassword = request.getParameter("confirmedPassword");

        try{
            User user = userService.signup(email, plainPassword, confirmedPassword);
            out.println("Signup successful");
        }catch(Exception e){
            out.println(e.getMessage());
        }

    }
}
