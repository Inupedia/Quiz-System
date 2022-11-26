<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</head>
<body>
<div id="root">
    <c:import url="nav.jsp" />
    <div class="d-flex align-items-center justify-content-center container" style="min-height: 100vh;">
        <div class="w-100" style="max-width: 400px;">
            <div class="card">
                <div class="card-body">
                    <h2 class="text-center mb-4">Sign Up</h2>
                    <form method="post" action="" class="">
                        <div class="m-2">
                            <label class="form-label" for="firstname">First Name</label>
                            <input required="" type="text" id="firstname" class="form-control" name="firstname">
                        </div>
                        <div class="m-2">
                            <label class="form-label" for="lastname">Last Name</label>
                            <input required="" type="text" id="lastname" class="form-control" name="lastname">
                        </div>
                        <div class="m-2">
                            <label class="form-label" for="email">Email</label>
                            <input required="" type="email" id="email" class="form-control" name="email">
                        </div>
                        <div class="m-2">
                            <label class="form-label" for="password">Password</label>
                            <input required="" type="password" id="password" class="form-control" name="password">
                        </div>
                        <div id="password-check" class="m-2">
                            <label class="form-label">Password Confirmation</label>
                            <input required="" type="password" class="form-control">
                        </div>
                        <div class="m-2 mt-4" style="max-width: 50vh;">
                            <button type="submit" class="w-100 custom-button btn btn-primary btn-dark">Sign Up</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="w-100 text-center mt-4">Already have an account? &nbsp;<a href="/login">Login</a></div>
        </div>
    </div>
</div>
</body>
</html>