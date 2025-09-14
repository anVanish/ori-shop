<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<h2>Categories list</h2>
<a class="btn" href="${pageContext.request.contextPath}/admin/categories/add">Add Category</a>
<br>
<table>
<thead>
  <tr class="table-header">
    <th>ID</th>
    <th>Category Name</th>
    <th>Number of Products</th>
    <th>Actions</th>
  </tr>
</thead>
<tbody>
    <c:if test="${empty categories}">
        <tr>
            <td colspan="2">No products found.</td>
        </tr>
    </c:if>

    <c:forEach var="c" items="${categories}">
        <tr>
            <td>${c.categoryId}</td>
            <td>${c.categoryName}</td>
            <td>${c.products.size()}</td>
            <td>
                <a class="btn" href="${pageContext.request.contextPath}/admin/categories/update?id=${c.categoryId}">Update</a>
                <a class="btn" href="${pageContext.request.contextPath}/admin/categories/delete?id=${c.categoryId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</tbody>
</table>