package com.vanish.javaweb.Controllers.User;

import com.vanish.javaweb.Entities.User;
import com.vanish.javaweb.Services.User.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdatePasswordController", value = "/me/password")
public class UpdatePasswordController extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/user/profile/updatePassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmedNewPassword = request.getParameter("confirmedNewPassword");
        try {
            if (!newPassword.equals(confirmedNewPassword)) throw new Exception("Password confirmed incorrect");
            userService.updatePassword(1, oldPassword, newPassword);
            request.getSession().setAttribute("message", "Update Password successfully");
            response.sendRedirect(request.getContextPath() + "/me");
        } catch (Exception e) {
            request.getSession().setAttribute("errorMessage", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/me/password");
        }

    }
}
