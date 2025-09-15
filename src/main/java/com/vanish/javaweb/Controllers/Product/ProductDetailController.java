package com.vanish.javaweb.Controllers.Product;

import com.vanish.javaweb.Entities.Product;
import com.vanish.javaweb.Services.Product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductDetailController", value = "/products/*")
public class ProductDetailController extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // e.g. "/1"
        try {
            if (pathInfo == null || pathInfo.isEmpty()) {
                throw new Exception("Product not found");
            }
            String idStr = pathInfo.substring(1);
            int productId = Integer.parseInt(idStr);
            Product product = productService.findById(productId);
            request.setAttribute("product", product);
            request.getRequestDispatcher("/views/user/product/detail.jsp").forward(request, response);

        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
