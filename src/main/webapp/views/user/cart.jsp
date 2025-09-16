<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div class="cart-container">
    <h1>${not empty sessionScope.user.userName ? sessionScope.user.userName : 'User'}'s Cart</h1>
    <table class="cart-table">
        <thead>
            <tr>
                <th>Product</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${empty carts}">
                <tr>
                    <td colspan="5">Your cart is empty.</td>
                </tr>
            </c:if>
            <c:forEach var="c" items="${carts}">
                <tr>
                    <td class="product-info">
                        <img src="${c.product.imageLink}" alt="${c.product.productName}">
                        <span>${c.product.productName}</span>
                    </td>
                    <td> <fmt:formatNumber value="${c.product.price}" type="number"/>đ</td>
                    <td>
                        <div class="quantity-control">
                            <a href="<c:url value='/cart/decrease?cartId=${c.cartId}' />" class="btn btn-modify">-</a>
                            <input type="number" value="${c.quantity}" min="1" disabled>
                            <a href="<c:url value='/cart/increase?cartId=${c.cartId}' />"  class="btn btn-modify">+</a>
                        </div>
                    </td>
                    <td><fmt:formatNumber value="${c.product.price * c.quantity}" type="number"/>đ</td>
                    <td><a href="<c:url value='/cart/delete?cartId=${c.cartId}'/>" class="remove-btn">x</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <c:if test="${not empty carts}">
        <div class="cart-summary">
            <h2>Cart Summary</h2>
            <p class="bottom"><strong>Total:</strong>
            <fmt:formatNumber value="${total}" type="number"/>đ</p>
            <button class="checkout-btn">Checkout</button>
        </div>
    </c:if>
</div>