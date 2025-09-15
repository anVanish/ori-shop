<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div class="container">
    <!-- Left side: Product image -->
    <div class="product-image">
      <img src="${product.imageLink}" alt="${product.productName}">
    </div>

    <!-- Right side: Product info -->
    <div class="product-info">
      <h1>${product.productName}</h1>
      <div class="product-price">${product.price}VND</div>
      <p>Views: ${product.views}</p>
      <a href="<c:url value='/products?categoryId=${product.category.categoryId}'/>">Category: ${product.category.categoryName}</a>
      <div class="product-desc">${product.description}</div>
      <div class="actions">
        <button class="btn btn-cart">Add to Cart</button>
      </div>
    </div>
  </div>

  <!-- Popular Products -->
  <section class="products">
    <h2>Popular Products</h2>
    <div class="product-list">
      <c:forEach var="p" items="${popularProducts}" varStatus="status">
          <a href="<c:url value='/products/${p.productId}'/>" class="product">
              <img src="${p.imageLink}" alt="${p.productName}">
              <h3 class="product-name">${p.productName}</h3>
              <p class="product-desc">${p.description}</p>
              <div class="price bottom">${p.price}VND</div>
              <button class="btn">Add to cart</button>
          </a>
      </c:forEach>
    </div>
  </section>

