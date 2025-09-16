<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!-- Categories -->
<section class="categories">
    <h2>Categories</h2>
    <div class="category-slider" id="categorySlider">
        <c:forEach var="c" items="${categories}">
            <a href="<c:url value='/products?categoryId=${c.categoryId}'/>" class="category">${c.categoryName}</a>
        </c:forEach>
    </div>
</section>

<!-- Popular Products -->
<section class="products">
  <h2>Popular Products</h2>
  <div class="product-list">
    <c:forEach var="p" items="${popularProducts}" varStatus="status">
        <div class="product">
            <a href="<c:url value='/products/${p.productId}'/>">
                <img src="${p.imageLink}" alt="${p.productName}">
                <h3 class="product-name">${p.productName}</h3>
            </a>
            <p class="product-desc">${p.description}</p>
            <div class="price bottom"><fmt:formatNumber value="${p.price}" type="number"/>đ</div>
            <a href="<c:url value='/cart/add?productId=${p.productId}' />" class="btn">Add to cart</a>
        </div>
    </c:forEach>
  </div>
</section>

