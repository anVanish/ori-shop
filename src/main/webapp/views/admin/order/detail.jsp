<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<a class="btn bottom" href="<c:url value='/admin/orders'/>"> Back</a>

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
      <div class="order-detail-info-row"><strong>Date:</strong> <fmt:formatDate value="${order.orderDateAsDate}" pattern="dd-MM-yyyy hh:mm:ss" /></div>
      <div class="order-detail-info-row"><strong>Total:</strong> <fmt:formatNumber value="${order.orderTotal}" type="Number" />đ</div>
      <div class="order-detail-info-row"><strong>Status:</strong> <span class="status ${order.orderStatus}">${order.orderStatus}</span></div>

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

    <form class="order-status-form" action="<c:url value='/admin/orders/update' />" method="post">
        <h3>Update Status</h3>
        <input type="hidden" name="orderId" value="${order.orderId}">

        <div class="order-status-row">
            <label for="status">Status:</label>
            <select id="status" name="status">
                <option value="confirm" ${order.orderStatus == 'confirm' ? 'selected' : ''}>Confirm</option>
                <option value="shipping" ${order.orderStatus == 'shipping' ? 'selected' : ''}>Shipping</option>
                <option value="completed" ${order.orderStatus == 'completed' ? 'selected' : ''}>Completed</option>
                <option value="cancelled" ${order.orderStatus == 'cancelled' ? 'selected' : ''}>Cancelled</option>
            </select>
        </div>

        <div class="order-status-actions">
            <button type="submit">Update</button>
        </div>

    </form>
  </div>
