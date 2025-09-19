<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div class="container">
    <!-- Sidebar filter -->
    <aside class="sidebar">
      <h3>Category</h3>
        <c:forEach var="c" items="${categories}">
            <label><input name="categoryId" value="${c.categoryId}" type="radio"
            <c:if test="${categoryId  == c.categoryId}">checked</c:if>
            > ${c.categoryName} (${c.products.size()})</label>
        </c:forEach>
        <label><input name="categoryId" type="radio" value="all"
            <c:if test="${categoryId == 0}">checked</c:if>
        > All</label>
      <hr>
    </aside>

    <!-- Product List -->
    <main class="products">
      <div class="product-list">
          <c:forEach var="p" items="${products}" varStatus="status">
              <div class="product">
                  <a href="<c:url value='/products/${p.productId}'/>">
                      <img src="${p.imageLink}" alt="${product.productName}">
                      <h3 class="product-name">${p.productName}</h3>
                  </a>
                  <p class="product-desc">${p.description}</p>
                  <div class="price bottom"><fmt:formatNumber value="${p.price}" type="number"/>đ</div>
                  <a href="<c:url value='/cart/add?productId=${p.productId}'/>" class="btn">Add to cart</a>
              </div>
          </c:forEach>
        </div>
    </main>
  </div>

<script>
  document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll("input[name='categoryId']").forEach(input => {
      input.addEventListener("change", function() {
        let categoryId = this.value;
        if (categoryId === "all") {
          window.location.href = "<c:url value='/products'/>";
        } else {
          window.location.href = "<c:url value='/products?categoryId='/>" + categoryId;
        }
      });
    });
  });
</script>