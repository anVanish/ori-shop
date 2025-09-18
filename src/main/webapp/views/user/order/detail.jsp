<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="order-detail-container">

    <!-- Left column: user info -->
    <div class="order-detail-card">
      <h3>Address</h3>
      <div class="order-detail-info-row"><strong>Name:</strong> ${order.user.userName}</div>
      <div class="order-detail-info-row"><strong>Email:</strong> ${order.user.email}</div>
      <div class="order-detail-info-row"><strong>Phone:</strong> ${order.user.phone}</div>
      <div class="order-detail-info-row"><strong>Address:</strong> ${order.user.street}, ${order.user.ward}, ${order.user.district}, ${order.user.city}</div>
    </div>

    <!-- Right column: order info -->
    <div class="order-detail-card">
      <h3>Order Information</h3>
      <div class="order-detail-info-row"><strong>Order ID:</strong> ${order.orderId}</div>
      <div class="order-detail-info-row"><strong>Date:</strong> <fmt:formatDate value="${order.orderDateAsDate}" pattern="dd-MM-yyyy" /></div>
      <div class="order-detail-info-row"><strong>Total:</strong> <fmt:formatNumber value="${order.orderTotal}" type="Number" />đ</div>
      <div class="order-detail-info-row"><strong>Status:</strong> <span class="status confirm">Confirm</span></div>

      <div class="order-detail-products">
        <h4>Products</h4>
        <c:forEach var="i" items="${order.orderItems}">
            <div class="order-detail-product-item">
              <img src="${i.product.imageLink}" alt="${i.product.productName}">
              <div class="order-detail-product-info">
                <div class="name">${i.product.productName}</div>
                <div class="qty">Quantity: ${i.quantity}</div>
              </div>
              <div class="price"><fmt:formatNumber value="${i.productPrice}" type="number"/>đ</div>
            </div>
        </c:forEach>
      </div>
    </div>

  </div>
