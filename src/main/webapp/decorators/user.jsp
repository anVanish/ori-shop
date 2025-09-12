<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/public/css/styles.css'/>">
</head>
<body>
	<%@ include file="/common/user/header.jsp" %>

	<h2>Hello World! from user</h2>
	<decorator:body></decorator:body>
	
	<%@ include file="/common/user/footer.jsp" %>
</body>
</html>
