<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!-- Main content -->
  <main class="auth-container">
    <div class="auth-card">
      <h2>Login</h2>
      <form action="" method="post" class="auth-form">
        <div class="form-group">
          <label for="email">Email</label>
          <input type="text" id="email" name="email" placeholder="Enter your email" required>
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" id="password" name="password" placeholder="Enter your password" required>
        </div>
        <button type="submit" class="btn">Login</button>
        <p class="form-footer">
          Don’t have an account? <a href="<c:url value='/signup'/>">Signup now</a>
        </p>
      </form>
    </div>
  </main>