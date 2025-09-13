<h2>Login Page</h2>

<form action="" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required> <br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required> <br><br>

    <a href="${pageContext.request.contextPath}/signup">No account? Signup now</a> <br/><br/>
    <button type="submit">Login</button>
</form>
