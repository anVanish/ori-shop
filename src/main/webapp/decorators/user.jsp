<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/public/css/styles.css'/>">
    <link rel="stylesheet" href="<c:url value='/public/css/toast.css'/>">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/common/user/header.jsp" %>

	<decorator:body></decorator:body>
	
	<%@ include file="/common/user/footer.jsp" %>

	<div id="toast" class="toast hidden">
        <span id="toast-message"></span>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            let toastTimeout;

            window.showToast = function(message, type = "success") {
                const $toast = $("#toast");

                // Close toast if it's currently open
                if (toastTimeout) {
                    clearTimeout(toastTimeout);
                    $toast.attr("class", `toast hidden ` + type);

                    setTimeout(() => {
                        displayToast(message, type);
                    }, 300);
                } else {
                    displayToast(message, type);
                }
            }

            function displayToast(message, type) {
                const $toast = $("#toast");
                const $toastMessage = $("#toast-message");

                $toastMessage.text(message || "Thông báo");
                $toast.attr("class", `toast visible ` + type);

                toastTimeout = setTimeout(() => {
                    $toast.attr("class", `toast hidden ` + type);
                    toastTimeout = null;
                }, 2000);
            }
        });
    </script>

    <c:if test="${not empty sessionScope.message}">
        <script>
           document.addEventListener("DOMContentLoaded", function () {
               showToast("${sessionScope.message}");
           });
        </script>
        <c:remove var="message" scope="session"/>
    </c:if>

    <c:if test="${not empty sessionScope.errorMessage}">
        <script>
           document.addEventListener("DOMContentLoaded", function () {
               showToast("${sessionScope.errorMessage}", "error");
           });
        </script>
        <c:remove var="errorMessage" scope="session"/>
    </c:if>


    <script src="<c:url value='/public/js/main.js'/>"></script>
</body>
</html>
