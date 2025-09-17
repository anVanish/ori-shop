package com.vanish.javaweb.Controllers.Cart;

import com.vanish.javaweb.Entities.Cart;
import com.vanish.javaweb.Model.UserModel;
import com.vanish.javaweb.Services.Cart.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartController", value = "/cart")
public class CartController extends HttpServlet {
    CartServiceImpl cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserModel userModel = (UserModel) request.getSession().getAttribute("user");
        List<Cart> carts = cartService.findAllByUser(userModel.getUserId());
        int total = 0;
        for (Cart c : carts) {
            total += c.getProduct().getPrice() * c.getQuantity();
        }

        request.setAttribute("carts", carts);
        request.setAttribute("total", total);
        request.getRequestDispatcher("/views/user/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
