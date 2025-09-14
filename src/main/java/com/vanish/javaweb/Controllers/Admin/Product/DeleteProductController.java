package com.vanish.javaweb.Controllers.Admin.Product;

import com.vanish.javaweb.Entities.Category;
import com.vanish.javaweb.Entities.Product;
import com.vanish.javaweb.Services.Product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteProductController", value = "/admin/products/delete")
public class DeleteProductController extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String paramId = request.getParameter("id");
        if (paramId != null) {
            try {
                int productId = Integer.parseInt(paramId);
                Product product = productService.findById(productId);
                if (product == null) throw new Exception("No product found");

                productService.delete(productId);

                request.getSession().setAttribute("message", "Delete Product successfully");
                response.sendRedirect(request.getContextPath() + "/admin/products");
            } catch (Exception e) {
                request.getSession().setAttribute("message", e.getMessage());
                response.sendRedirect(request.getContextPath() + "/admin/products");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
