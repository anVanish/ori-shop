package com.vanish.javaweb.Controllers.User;

import com.vanish.javaweb.Entities.User;
import com.vanish.javaweb.Model.UserModel;
import com.vanish.javaweb.Services.User.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserController", value = "/me")
public class UserController extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get user id from session
        User user = userService.findById(1);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/views/user/profile/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
