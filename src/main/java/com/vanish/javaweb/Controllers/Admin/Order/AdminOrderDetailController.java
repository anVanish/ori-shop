package com.vanish.javaweb.Controllers.Admin.Order;

import com.vanish.javaweb.Entities.Order;
import com.vanish.javaweb.Services.Order.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminOrderDetailController", value = "/admin/orders/*")
public class AdminOrderDetailController extends HttpServlet {
    OrderServiceImpl orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // e.g. "/1"
        try {
            if (pathInfo == null || pathInfo.isEmpty()) {
                throw new Exception("Order not found");
            }
            String idStr = pathInfo.substring(1);
            int orderId = Integer.parseInt(idStr);
            Order order = orderService.findById(orderId);

            request.setAttribute("order", order);
            request.getRequestDispatcher("/views/admin/order/detail.jsp").forward(request, response);

        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }
}
