<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!-- Hero Slider -->
<section class="slider">
    <div class="slides" id="slides">
        <img src="https://neambo.com/files/images/act2-hero-slider-minimum-height-full-vh.jpg" alt="">
        <img src="https://neambo.com/files/images/act2-hero-slider-minimum-height-full-vh.jpg" alt="">
        <img src="https://neambo.com/files/images/act2-hero-slider-minimum-height-full-vh.jpg" alt="">
    </div>
    <button class="prev" onclick="moveSlide(-1)">&#10094;</button>
    <button class="next" onclick="moveSlide(1)">&#10095;</button>
</section>

<!-- Categories -->
<section class="categories">
    <h2>Categories</h2>
    <div class="category-slider" id="categorySlider">
        <c:forEach var="c" items="${categories}">
            <a href="#?categoryId=${c.categoryId}" class="category">${c.categoryName}</a>
        </c:forEach>
    </div>
</section>

<!-- Popular Products -->
<section class="products">
  <h2>Popular Products</h2>
  <div class="product-list">
    <c:forEach var="p" items="${popularProducts}" varStatus="status">
        <a href="<c:url value='/products/${p.productId}'/>" class="product">
            <img src="p.imageLink" alt="Product ${status.index + 1}">
            <h3 class="product-name">${p.productName}</h3>
            <p class="product-desc">${p.description}</p>
            <div class="price">${p.price}VND</div>
        </a>
    </c:forEach>
  </div>
</section>

