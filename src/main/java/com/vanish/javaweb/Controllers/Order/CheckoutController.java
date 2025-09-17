package com.vanish.javaweb.Controllers.Order;

import com.vanish.javaweb.Entities.Cart;
import com.vanish.javaweb.Entities.User;
import com.vanish.javaweb.Model.UserModel;
import com.vanish.javaweb.Services.Cart.CartServiceImpl;
import com.vanish.javaweb.Services.User.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckoutController", value = "/checkout")
public class CheckoutController extends HttpServlet {
    CartServiceImpl cartService = new CartServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserModel userModel = (UserModel) request.getSession().getAttribute("user");
        List<Cart> carts = cartService.findAllByUser(userModel.getUserId());
        User user = userService.findById(userModel.getUserId());
        int total = 0;
        for (Cart c : carts) {
            total += c.getProduct().getPrice() * c.getQuantity();
        }

        request.setAttribute("user", user);
        request.setAttribute("carts", carts);
        request.setAttribute("total", total);
        request.getRequestDispatcher("/views/user/order/checkout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
