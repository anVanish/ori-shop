package com.vanish.javaweb.Controllers;

import com.vanish.javaweb.Entities.Category;
import com.vanish.javaweb.Entities.Product;
import com.vanish.javaweb.Services.Category.CategoryServiceImpl;
import com.vanish.javaweb.Services.Product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", value = "/home")
public class HomeController extends HttpServlet {
    CategoryServiceImpl categoryService = new CategoryServiceImpl();
//    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//        List<Product> products = productService.findAll();
        List<Category> categories = categoryService.findAll();
//        request.setAttribute("products", products);
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        doGet(request, response);
    }
}
