<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</head>

<body>
<div id="root">
    <c:import url="nav.jsp" />
    <div class="d-flex align-items-center justify-content-center container" style="min-height: 100vh;">
        <div class="w-100" style="max-width: 400px;">
            <div class="card"><div class="card-body">
                <h2 class="text-center mb-4">Log In</h2>
                <form method="post" action="" class="">
                    <div id="email" class="m-2">
                        <div class="mb-3 form-floating">
                            <input placeholder="name@inupedia.com" required="" type="email" id="login-email" class="form-control" name="email">
                            <label for="login-email">Email</label>
                        </div>
                    </div>
                    <div id="password" class="m-2">
                        <div class="mb-3 form-floating">
                            <input placeholder="password" required="" type="password" id="login-password" class="form-control" name="password">
                            <label for="login-password">Password</label>
                        </div>
                    </div>
                    <div class="m-2 mt-4" style="max-width: 50vh;">
                        <button type="submit" class="w-100 custom-button btn btn-primary btn-dark">Login</button>
                    </div>
                </form>
            </div>
            </div>
                <div class="w-100 text-center mt-4">Need an account? &nbsp;<a href="/register">Sign up</a>
            </div>
            <div class="line"></div>
        </div>
    </div>
</div>
</body>

</html>
