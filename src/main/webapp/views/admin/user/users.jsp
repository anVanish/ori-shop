<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<h2>Users list</h2>
<table>
<thead>
  <tr class="table-header">
    <th></th>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Address</th>
  </tr>
</thead>
<tbody>
    <c:if test="${empty users}">
        <tr>
            <td colspan="7">No products found.</td>
        </tr>
    </c:if>

    <c:forEach var="u" items="${users}">
        <tr>
            <td><img src="${u.imageLink}" alt="User ${u.userId}"/></td>
            <td>${u.userId}</td>
            <td>${u.userName}</td>
            <td>${u.email}</td>
            <td>${u.phone}</td>
            <td>
                <c:if test="${not empty u.city}">
                    ${u.street}, ${u.ward}, ${u.district}, ${u.city}
                </c:if>
            </td>
        </tr>
    </c:forEach>
</tbody>
</table>