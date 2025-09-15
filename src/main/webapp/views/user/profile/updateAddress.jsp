<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!-- Main content -->
<main class="auth-container">

    <div class="auth-card">
        <h2>Update Address</h2>
        <form action="" method="post" class="auth-form">
            <div class="form-group">
                <label for="city">City</label>
                <input type="text" id="city" name="city" value="${user.city}" required>
            </div>
            <div class="form-group">
                <label for="district">District</label>
                <input type="text" id="district" name="district" required value="${user.district}">
            </div>
            <div class="form-group">
                <label for="ward">Ward</label>
                <input type="text" id="ward" name="ward" value="${user.ward}" required>
            </div>
            <div class="form-group">
                <label for="street">Street</label>
                <input type="text" id="street" name="street" value="${user.street}" required>
            </div>
            <button type="submit" class="btn bottom">Update</button>

            <p class="form-footer">
               Up to date? <a href="<c:url value='/me' />">Back</a>
            </p>
        </form>
    </div>
</main>