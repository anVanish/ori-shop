package com.vanish.javaweb.Controllers.Product;

import com.vanish.javaweb.Entities.Product;
import com.vanish.javaweb.Services.Product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryIdStr = request.getParameter("categoryId");
        if (categoryIdStr != null){
            request.setAttribute("categoryId", categoryIdStr);
        }

        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/views/user/product/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
