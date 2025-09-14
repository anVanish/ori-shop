<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/public/css/styles-admin.css'/>">
    <link rel="stylesheet" href="<c:url value='/public/css/toast.css'/>">
    <link rel="stylesheet" href="<c:url value='/public/css/modal.css'/>">
    <link rel="stylesheet" href="<c:url value='/public/css/modal.css'/>">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="<c:url value='/public/js/modal.js'/>"></script>
</head>
<body>
    <div class="content">
        <c:if test="${not empty sessionScope.user}">
            <div class="sidebar">
                <%@ include file="/common/admin/sidebar.jsp" %>
            </div>
        </c:if>

        <div class="main">
            <decorator:body></decorator:body>
        </div>
    </div>

    <div class="footer">
        &copy; 2025 My Website. All rights reserved.
        <%@ include file="/common/admin/footer.jsp" %>
    </div>

	<div id="toast" class="toast hidden">
        <span id="toast-message"></span>
    </div>


    <!-- Confirm Delete Modal -->
    <div id="customModal" class="modal">
      <div class="modal-content">
        <h3 id="modalTitle">Confirm Delete</h3>
        <p id="modalMessage">Are you sure you want to delete category <span id="cateName"></span>?</p>
        <div class="modal-actions">
          <button id="modalCancel" class="btn">Cancel</button>
          <button id="modalOk" class="btn btn-danger">Delete</button>
        </div>
      </div>
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
</body>
</html>
