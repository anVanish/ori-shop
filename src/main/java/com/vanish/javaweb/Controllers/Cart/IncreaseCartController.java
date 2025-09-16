package com.vanish.javaweb.Controllers.Cart;

import com.vanish.javaweb.Entities.Cart;
import com.vanish.javaweb.Entities.Product;
import com.vanish.javaweb.Entities.User;
import com.vanish.javaweb.Services.Cart.CartServiceImpl;
import com.vanish.javaweb.Services.Product.ProductServiceImpl;
import com.vanish.javaweb.Services.User.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IncreaseCartController", value = "/cart/increase")
public class IncreaseCartController extends HttpServlet {
    CartServiceImpl cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String paramId = request.getParameter("cartId");
        if (paramId != null) {
            try {
                int cartId = Integer.parseInt(paramId);
                Cart cart = cartService.findById(cartId);
                if (cart == null) throw new Exception("Cart not found");

                cartService.increaseCartItem(cart);
            } catch (Exception e) {
                request.getSession().setAttribute("errorMessage", e.getMessage());
            }
        }
        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
