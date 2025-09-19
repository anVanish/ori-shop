package com.vanish.javaweb.Controllers.Product;

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

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    CategoryServiceImpl categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryIdStr = request.getParameter("categoryId");
        int categoryId = 0;
        if (categoryIdStr != null){
            try{
                categoryId = Integer.parseInt(categoryIdStr);
            } catch (Exception e){
            }
        }
        request.setAttribute("categoryId", categoryId);

        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);

        List<Product> products;
        if (categoryId != 0){
            Category category = categoryService.findCateById(categoryId);
            products = category.getProducts();
        } else{
            products = productService.findAll();
        }

        request.setAttribute("products", products);
        request.getRequestDispatcher("/views/user/product/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
