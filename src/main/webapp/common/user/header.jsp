<ul>
	<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
	<li><a href="#">Product</a></li>
	<li><a href="#">About</a></li>
	<li><a href="#">Cart</a></li>
	<li><a href="#">User</a></li>

	<c:choose>
        <c:when test="${not empty sessionScope.user}">
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </c:when>
        <c:otherwise>
        	<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
        </c:otherwise>
    </c:choose>


</ul>