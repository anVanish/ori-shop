<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div class="container">
    <!-- Sidebar filter -->
    <aside class="sidebar">
        <div class="user-card">
        <h3>Hello ${user.userName}</h3>
            <img src="${user.imageLink}" alt="${user.userName}">
            <div class="user-name">${user.userName}</div>
            <div class="user-email">${user.email}</div>
            <a href="<c:url value='/me/update' />" class="btn bottom">Profile</a>
            <a href="<c:url value='/me/address' />" class="btn bottom">Address</a>
            <a href="<c:url value='/me/password' />" class="btn">Password</a>

        </div>
    </aside>

    <!-- Product List -->
    <main class="products">
        <h3>Orders list</h3>
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