package com.vanish.javaweb.Controllers.Order;

import com.vanish.javaweb.Entities.Cart;
import com.vanish.javaweb.Entities.Order;
import com.vanish.javaweb.Entities.OrderItem;
import com.vanish.javaweb.Entities.User;
import com.vanish.javaweb.Model.UserModel;
import com.vanish.javaweb.Services.Cart.CartServiceImpl;
import com.vanish.javaweb.Services.Order.OrderServiceImpl;
import com.vanish.javaweb.Services.User.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CreateOrderController", value = "/order/create")
public class CreateOrderController extends HttpServlet {
    OrderServiceImpl orderService = new OrderServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();
    CartServiceImpl cartService = new CartServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserModel userModel = (UserModel) request.getSession().getAttribute("user");

        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String ward = request.getParameter("ward");
        String street = request.getParameter("street");

        try {
            List<Cart> carts = cartService.findAllByUser(userModel.getUserId());
            User user = userService.findById(userModel.getUserId());
            List<OrderItem> orderItems = new ArrayList<>();
            double orderTotal = 0;

            Order order = new Order.Builder()
                    .setUser(user)
                    .setUserName(userName)
                    .setPhone(phone)
                    .setEmail(email)
                    .setCity(city)
                    .setDistrict(district)
                    .setWard(ward)
                    .setStreet(street)
                    .build();

            for (Cart c : carts) {
                double total = c.getProduct().getPrice() * c.getQuantity();
                OrderItem orderItem = new OrderItem.Builder()
                        .setOrder(order)
                        .setProduct(c.getProduct())
                        .setQuantity(c.getQuantity())
                        .setTotal(total)
                        .build();
                orderTotal += total;
                orderItems.add(orderItem);
            }

            order.setOrderTotal(orderTotal);
            order.setOrderItems(orderItems);

            orderService.insert(order);
            cartService.clearCart(userModel.getUserId());
            request.getSession().setAttribute("message", "Order successfully");
            response.sendRedirect(request.getContextPath() + "/me");
        } catch (Exception e) {
            request.getSession().setAttribute("errorMessage", e.getMessage());
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
//            response.sendRedirect(request.getContextPath() + "/checkout");
        }
    }
}
