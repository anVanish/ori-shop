package com.vanish.javaweb.Controllers.Cart;

import com.vanish.javaweb.Entities.Cart;
import com.vanish.javaweb.Entities.Category;
import com.vanish.javaweb.Entities.Product;
import com.vanish.javaweb.Entities.User;
import com.vanish.javaweb.Model.UserModel;
import com.vanish.javaweb.Services.Cart.CartServiceImpl;
import com.vanish.javaweb.Services.Product.ProductServiceImpl;
import com.vanish.javaweb.Services.User.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddCartController", value = "/cart/add")
public class AddCartController extends HttpServlet {
    CartServiceImpl cartService = new CartServiceImpl();
    ProductServiceImpl productService = new ProductServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String paramId = request.getParameter("productId");
        if (paramId != null) {
            try {
                UserModel userModel = (UserModel) request.getSession().getAttribute("user");

                int productId = Integer.parseInt(paramId);
                Product product = productService.findById(productId);
                if (product == null) throw new Exception("Product not found");
                User user = userService.findById(userModel.getUserId());
                if (user == null) throw new Exception("Please login to continue");

                cartService.addToCart(user, product);
                request.getSession().setAttribute("message", "Successfully add " + product.getProductName());
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
