<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<main class="orders">
     <div class="order-list">
       <table class="order-table">
         <thead>
           <tr>
             <th>ID</th>
             <th>Products</th>
             <th>User</th>
             <th>Date</th>
             <th>Total</th>
             <th>Status</th>
             <th>Action</th>
           </tr>
         </thead>
         <tbody>
           <!-- Order row -->
           <c:if test="${empty orders}">
                <tr>
                 <td class="center" colspan="7">No order found</td>
               </tr>
           </c:if>
           <c:forEach var="o" items="${orders}">
               <tr>
                 <td>${o.orderId}</td>
                 <td>
                     <c:forEach var="i" items="${o.orderItems}">
                       <div class="product-item">
                         <img src="${i.product.imageLink}" alt="Product">
                         <div class="order-product-info">
                           <div class="product-name">${i.product.productName}</div>
                           <div class="product-qty">Quantity: ${i.quantity}</div>
                         </div>
                       </div>
                    </c:forEach>
                 </td>
                 <td>${o.user.userName}</td>
                 <td><fmt:formatDate value="${o.orderDateAsDate}" pattern="dd-MM-yyyy" /></td>
                 <td><fmt:formatNumber value="${o.orderTotal}" type="number" />đ</td>
                 <td><span class="status ${o.orderStatus}">Confirm</span></td>
                 <td><a href="<c:url value='/admin/orders/${o.orderId}'/>" class="btn-view">View</a></td>
               </tr>
           </c:forEach>
         </tbody>
       </table>
     </div>
   </main>