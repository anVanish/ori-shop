<h2>Sign Up Page</h2>

<form action="" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required> <br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required> <br><br>

    <label for="confirmedPassword">Confirm Password:</label>
        <input type="password" id="confirmedPassword" name="confirmedPassword" required> <br><br>

    <a href="${pageContext.request.contextPath}/login">Have account? Login now</a> <br/><br/>
    <button type="submit">Sign up</button>
</form>
