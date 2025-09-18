package com.vanish.javaweb.Controllers.User;

import com.vanish.javaweb.Entities.Order;
import com.vanish.javaweb.Entities.User;
import com.vanish.javaweb.Model.UserModel;
import com.vanish.javaweb.Services.Order.OrderServiceImpl;
import com.vanish.javaweb.Services.User.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", value = "/me")
public class UserController extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();
    OrderServiceImpl orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get user id from session
        UserModel userModel = (UserModel) request.getSession().getAttribute("user");
        User user = userService.findById(userModel.getUserId());

        List<Order> orders = orderService.findAllByUser(user.getUserId());

        request.setAttribute("user", user);
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/views/user/profile/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
