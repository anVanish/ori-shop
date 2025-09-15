<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!-- Main content -->
<main class="auth-container">
    <div class="auth-card">
        <h2>Update Password</h2>
        <form action="" method="post" class="auth-form">
            <div class="form-group">
                <label for="oldPassword">Old Password</label>
                <input type="password" id="oldPassword" name="oldPassword" required>
            </div>
            <div class="form-group">
                <label for="newPassword">New Password</label>
                <input type="password" id="newPassword" name="newPassword" required>
            </div>
            <div class="form-group">
                <label for="confirmedNewPassword">Confirm New Password</label>
                <input type="password" id="confirmedNewPassword" name="confirmedNewPassword" required>
            </div>
            <button type="submit" class="btn">Update</button>

            <p class="form-footer">
               Up to date? <a href="<c:url value='/me' />">Back</a>
            </p>
        </form>
    </div>
</main>