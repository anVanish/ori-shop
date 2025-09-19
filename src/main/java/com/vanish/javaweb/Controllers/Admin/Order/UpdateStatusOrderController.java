package com.vanish.javaweb.Controllers.Admin.Order;

import com.vanish.javaweb.Services.Order.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateStatusOrderController", value = "/admin/orders/update")
public class UpdateStatusOrderController extends HttpServlet {
    OrderServiceImpl orderService = new OrderServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("orderId");
        String status = request.getParameter("status");

        try {
            int orderId = Integer.parseInt(idStr);
            orderService.updateStatus(orderId, status);
            request.getSession().setAttribute("message", "Update status successfully");
        } catch (Exception e) {
            request.getSession().setAttribute("errorMessage", e.getMessage());
            response.getWriter().println(e.getMessage());
            return;
        }
        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }
}
