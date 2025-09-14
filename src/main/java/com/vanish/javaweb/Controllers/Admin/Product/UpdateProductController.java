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
import java.util.List;

@WebServlet(name = "UpdateProductController", value = "/admin/products/update")
public class UpdateProductController extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    CategoryServiceImpl categoryService = new CategoryServiceImpl();

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

                request.setAttribute("product", product);
            } catch (Exception e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
                return;
            }
        }
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        request.setAttribute("isUpdate", true);
        request.getRequestDispatcher("/views/admin/product/manageProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //request body
        String paramId = request.getParameter("id");
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String categoryId = request.getParameter("categoryId");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String imageLink = request.getParameter("imageLink");

        if (paramId != null) {
            try {
                int productId = Integer.parseInt(paramId);
                Product product = productService.findById(productId);
                if (product == null) throw new Exception("No category found");
                Category category = new Category.Builder().setCategoryId(Integer.parseInt(categoryId)).build();

                //update product
                product.setProductName(productName);
                product.setDescription(description);
                product.setPrice(Integer.parseInt(price));
                product.setStock(Integer.parseInt(stock));
                product.setCategory(category);
                product.setImageLink(imageLink);
                productService.update(product);

                request.getSession().setAttribute("message", "Update Product successfully");
                response.sendRedirect(request.getContextPath() + "/admin/products");
            } catch (Exception e) {
                request.getSession().setAttribute("message", e.getMessage());
                response.sendRedirect(request.getContextPath() + "/admin/products/update");
            }
        }
    }
}
