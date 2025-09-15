<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div class="container">
    <!-- Sidebar filter -->
    <aside class="sidebar">
      <h3>Filter Products</h3>
      <label><input type="checkbox"> Category A</label>
      <label><input type="checkbox"> Category B</label>
      <label><input type="checkbox"> Category C</label>
      <hr>
      <h3>Price</h3>
      <label><input type="checkbox"> Under $50</label>
      <label><input type="checkbox"> $50 - $100</label>
      <label><input type="checkbox"> Above $100</label>
    </aside>

    <!-- Product List -->
    <main class="products">
      <div class="product-list">
          <c:forEach var="p" items="${products}" varStatus="status">
              <a href="<c:url value='/products/${p.productId}'/>" class="product">
                  <img src="${p.imageLink}" alt="${product.productName}">
                  <h3 class="product-name">${p.productName}</h3>
                  <p class="product-desc">${p.description}</p>
                  <div class="price bottom">${p.price}VND</div>
                  <button class="btn">Add to cart</button>
              </a>
          </c:forEach>
        </div>
    </main>
  </div>