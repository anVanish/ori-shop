<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!-- Main content -->
<main class="auth-container">
    <div class="auth-card">
        <h2>Update Profile</h2>
        <form action="" method="post" class="auth-form">
            <div class="form-group">
                <label for="userName">Name</label>
                <input type="text" id="userName" name="userName" value="${user.userName}">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required value="${user.email}">
            </div>
            <div class="form-group">
                <label for="phone">Phone</label>
                <input type="text" id="phone" name="phone" value="${user.phone}">
            </div>
            <div class="form-group">
                <label for="imageLink">Image Link</label>
                <input type="text" id="imageLink" name="imageLink" value="${user.imageLink}">
            </div>
            <button type="submit" class="btn">Update</button>

            <p class="form-footer">
               Up to date? <a href="<c:url value='/me' />">Back</a>
            </p>
        </form>
    </div>
</main>