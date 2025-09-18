<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div class="checkout-container">
    <!-- Left: Billing Form -->
    <form class="checkout-form" action="<c:url value='/order/create'/>" method="POST">
      <h2>Checkout</h2>

      <div class="form-grid">
          <!-- Left: Personal Info -->
          <div>
            <div class="form-group">
              <label for="userName">Full Name</label>
              <input type="text" id="userName" name="userName" value="${user.userName}" required >
            </div>
            <div class="form-group">
              <label for="phone">Phone</label>
              <input type="tel" id="phone" name="phone" value="${user.phone}" required >
            </div>
            <div class="form-group">
              <label for="email">Email</label>
              <input type="email" id="email" name="email" value="${user.email}" required >
            </div>
          </div>

          <!-- Right: Address -->
          <div>
            <div class="form-group">
              <label>Address</label>
              <div class="form-group address-grid">
                <input type="text" placeholder="City" name="city" value="${user.city}" required >
                <input type="text" placeholder="District" name="district" value="${user.district}" required >
              </div>
              <div class="form-group">
                <label for="ward">Ward</label>
                <input type="text" id="ward" name="ward" value="${user.ward}" required >
              </div>
              <div class="form-group">
                <label for="street">Street</label>
                <input type="text" id="street" name="street" value="${user.street}" required >
              </div>
            </div>

          </div>
        </div>
      <div class="payment-methods">
        <h3>Payment Method</h3>
        <label class="payment-method">
          <input type="radio" name="payment" checked> Cash on Delivery
        </label>
      </div>

      <button class="btn" type="submit">Confirm Order</button>
    </form>

    <!-- Right: Order Summary -->
    <div class="order-summary">
      <h3>Order Summary</h3>
        <c:forEach var="c" items="${carts}">
          <div class="order-item">
            <span>${c.product.productName} x${c.quantity}</span>
            <span><fmt:formatNumber value="${c.product.price * c.quantity}" type="number"/>đ</span>
          </div>
        </c:forEach>

      <div class="total">
        Total: <fmt:formatNumber value="${total}" type="number"/>đ
      </div>
    </div>
  </div>