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

@WebServlet(name = "UpdateProfileController", value = "/me/update")
public class UpdateProfileController extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.findById(1);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/views/user/profile/updateProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //get id from session
        UserModel userModel = (UserModel) request.getSession().getAttribute("user");
        User user = userService.findById(userModel.getUserId());

        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String imageLink = request.getParameter("imageLink");
        String phone = request.getParameter("phone");

        user.setUserName(userName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setImageLink(imageLink);

        userService.update(user);

        request.getSession().setAttribute("message", "Update Profile successfully");
        response.sendRedirect(request.getContextPath() + "/me");
    }
}
