<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/public/css/styles.css'/>">
</head>
<body>
	<%@ include file="/common/user/header.jsp" %>
	<c:if test="${not empty hasSidebar}">
    <%@ include file="/common/user/sidebar.jsp" %>
    </c:if>

	<decorator:body></decorator:body>
	
	<%@ include file="/common/user/footer.jsp" %>
</body>
</html>
