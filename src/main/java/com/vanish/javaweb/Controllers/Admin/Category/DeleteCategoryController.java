package com.vanish.javaweb.Controllers.Admin.Category;

import com.vanish.javaweb.Entities.Category;
import com.vanish.javaweb.Services.Category.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCategoryController", value = "/admin/categories/delete")
public class DeleteCategoryController extends HttpServlet {
    CategoryServiceImpl categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String paramId = request.getParameter("id");
        String categoryName = request.getParameter("categoryName");
        if (paramId != null) {
            try {
                int categoryId = Integer.parseInt(paramId);
                Category category = categoryService.findCateById(categoryId);
                if (category == null) throw new Exception("No category found");

                categoryService.delete(categoryId);

                request.getSession().setAttribute("message", "Delete Category successfully");
                response.sendRedirect(request.getContextPath() + "/admin/categories");
            } catch (Exception e) {
                request.getSession().setAttribute("message", e.getMessage());
                response.sendRedirect(request.getContextPath() + "/admin/categories");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
