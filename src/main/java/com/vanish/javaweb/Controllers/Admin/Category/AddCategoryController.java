package com.vanish.javaweb.Controllers.Admin.Category;

import com.vanish.javaweb.Entities.Category;
import com.vanish.javaweb.Services.Category.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AddCategoryController", value = "/admin/categories/add")
public class AddCategoryController extends HttpServlet {
    CategoryServiceImpl categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/admin/category/manageCategory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            String name = request.getParameter("categoryName");
            Category category = new Category.Builder().setCategoryName(name).build();
            categoryService.insert(category);
            request.getSession().setAttribute("message", "Add category successfully");
            response.sendRedirect(request.getContextPath() + "/admin/categories");
        } catch (Exception e) {
            request.getSession().setAttribute("errorMessage", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/admin/categories/add");
        }
    }
}
