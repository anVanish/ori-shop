package com.vanish.javaweb.Controllers.Admin.Product;

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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AddProductController", value = "/admin/products/add")
public class AddProductController extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    CategoryServiceImpl categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/views/admin/product/manageProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        try {
            String name = request.getParameter("productName");
            String description = request.getParameter("description");
            String categoryId = request.getParameter("categoryId");
            String price = request.getParameter("price");
            String stock = request.getParameter("stock");
            String imageLink = request.getParameter("imageLink");

            Category category = new Category.Builder().setCategoryId(Integer.parseInt(categoryId)).build();
            Product product = new Product.Builder()
                    .setProductName(name)
                    .setDescription(description)
                    .setPrice(Integer.parseInt(price))
                    .setStock(Integer.parseInt(stock))
                    .setImageLink(imageLink)
                    .setCategory(category)
                    .build();
            productService.insert(product);
            request.getSession().setAttribute("message", "Add product successfully");
            response.sendRedirect(request.getContextPath() + "/admin/products");
        } catch (Exception e) {
            request.getSession().setAttribute("errorMessage", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/admin/products/add");
        }

    }
}
