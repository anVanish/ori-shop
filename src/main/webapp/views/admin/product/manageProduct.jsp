<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<a class="btn bottom" href="${pageContext.request.contextPath}/admin/products">Back</a>
<div class="form-container">
    <h2>${isAdd ? 'Add' : "Update"} product</h2>
    <form action="" method="POST">
        <div class="form-group">
            <label for="productId">Product Id</label>
            <input type="text" id="productId" name="productId" disabled required
            value="${not empty product ? product.productId : ''}">
        </div>

        <div class="form-group">
            <label for="productName">Name</label>
            <input type="text" id="productName" name="productName" required
            value="${not empty product ? product.productName : ''}">
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <textarea type="text" id="description" name="description" required>${not empty product ? product.description : ''}</textarea>
        </div>

        <div class="form-group">
            <label for="categoryId">Category</label>
            <select id="categoryId" name="categoryId">
                <c:forEach var="c" items="${categories}">
                    <option value="${c.categoryId}" <c:if test="${c.categoryId == product.category.categoryId}">selected</c:if>>${c.categoryName}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <input type="text" id="price" name="price" required
            value="${not empty product ? product.price : ''}">
        </div>


        <div class="form-group">
            <label for="stock">Stock</label>
            <input type="text" id="stock" name="stock" required
            value="${not empty product ? product.stock : ''}">
        </div>

        <div class="form-group">
            <label for="imageLink">Image</label>
            <input type="text" id="imageLink" name="imageLink" required
            value="${not empty product ? product.imageLink : ''}">
        </div>

        <button type="submit" class="btn">${isAdd ? 'Add' : "Update"}</button>
    </form>
</div>