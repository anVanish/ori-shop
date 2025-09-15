package com.vanish.javaweb.Controllers.User;

import com.vanish.javaweb.Entities.User;
import com.vanish.javaweb.Services.User.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateAddressController", value = "/me/address")
public class UpdateAddressController extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.findById(1);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/views/user/profile/updateAddress.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //get id from session
        User user = userService.findById(1);
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String ward = request.getParameter("ward");
        String street = request.getParameter("street");

        user.setCity(city);
        user.setDistrict(district);
        user.setWard(ward);
        user.setStreet(street);

        userService.update(user);

        request.getSession().setAttribute("message", "Update Address successfully");
        response.sendRedirect(request.getContextPath() + "/me");
    }
}
