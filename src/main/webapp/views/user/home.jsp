<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<h2>Hello World! from Home</h2>
<h2>Message: ${message}</h2>

<h3>Danh sách Danh mục ${categories}</h3>
<c:forEach var="cate" items="${categories}" varStatus="st">
    <p>${cate.categoryId} → ${cate.categoryName}</p>
</c:forEach>