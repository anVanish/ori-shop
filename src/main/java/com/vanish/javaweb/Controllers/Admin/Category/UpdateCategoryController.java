package com.vanish.javaweb.Controllers.Admin.Category;

import com.vanish.javaweb.Entities.Category;
import com.vanish.javaweb.Services.Category.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.spec.ECField;

@WebServlet(name = "UpdateCategoryController", value = "/admin/categories/update")
public class UpdateCategoryController extends HttpServlet {
    CategoryServiceImpl categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramId = request.getParameter("id");
        if (paramId != null) {
            try {
                int categoryId = Integer.parseInt(paramId);
                Category category = categoryService.findCateById(categoryId);
                if (category == null) throw new Exception("No category found");
                request.setAttribute("category", category);
            } catch (Exception e) {
                // Handle invalid number
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
                return;
            }
        }

        request.setAttribute("isUpdate", true);
        request.getRequestDispatcher("/views/admin/category/manageCategory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String paramId = request.getParameter("id");
        String categoryName = request.getParameter("categoryName");
        if (paramId != null) {
            try {
                int categoryId = Integer.parseInt(paramId);
                Category category = categoryService.findCateById(categoryId);
                if (category == null) throw new Exception("No category found");
                category.setCategoryName(categoryName);
                categoryService.update(category);

                request.getSession().setAttribute("message", "Update Category successfully");
                response.sendRedirect(request.getContextPath() + "/admin/categories");
            } catch (Exception e) {
                request.getSession().setAttribute("message", e.getMessage());
                response.sendRedirect(request.getContextPath() + "/admin/categories/update");
            }
        }
    }
}
