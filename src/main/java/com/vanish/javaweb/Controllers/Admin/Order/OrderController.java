package com.vanish.javaweb.Controllers.Admin.Order;

import com.vanish.javaweb.Entities.Order;
import com.vanish.javaweb.Services.Order.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderController", value = "/admin/orders")
public class OrderController extends HttpServlet {
    OrderServiceImpl orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = orderService.findAll();

        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/views/admin/order/orders.jsp").forward(request, response);
    }
}
