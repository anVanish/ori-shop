<header>
    <h1><a href="<c:url value='/home'/>">OriShop</a></h1>
    <nav>
        <a href="<c:url value='/home'/>">Home</a>
        <a href="<c:url value='/products'/>">Products</a>
        <a href="<c:url value='/cart'/>">Cart</a>
        <a href="<c:url value='/me'/>">User</a>
        <c:choose>
        <c:when test="${not empty sessionScope.user}">
            <a href="<c:url value='/logout'/>">Logout</a>
        </c:when>
        <c:otherwise>
            <a href="<c:url value='/login'/>">Login</a>
        </c:otherwise>
        </c:choose>

    </nav>
  </header>
