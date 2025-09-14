<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<h2>Products list</h2>
<a class="btn bottom" href="${pageContext.request.contextPath}/admin/products/add">Add Product</a>
<br>
<table>
<thead>
  <tr class="table-header">
    <th></th>
    <th>ID</th>
    <th>Name</th>
    <th>Category</th>
    <th>Stock</th>
    <th>Price</th>
    <th>Action</th>
  </tr>
</thead>
<tbody>
    <c:if test="${empty products}">
        <tr>
            <td colspan="7">No products found.</td>
        </tr>
    </c:if>

    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.imageLink}</td>
            <td>${p.productId}</td>
            <td>${p.productName}</td>
            <td>${p.category.categoryName}</td>
            <td>${p.stock}</td>
            <td>${p.price}</td>
            <td>
                <a class="btn" href="${pageContext.request.contextPath}/admin/products/update?id=${p.productId}">Update</a>
                <a class="btn" onclick="showModal(
                    'Delete Product',
                    'Do you want to delete product \'${p.productName}\'?',
                    '${pageContext.request.contextPath}/admin/products/delete?id=${p.productId}')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</tbody>
</table>