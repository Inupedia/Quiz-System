<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dashboard</title>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
            integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
            crossorigin="anonymous"
    />
    <style><%@include file="style/dashboard.css"%></style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-auto bg-light sticky-top bg-dark">
            <div
                    class="d-flex flex-sm-column flex-row flex-nowrap bg-dark align-items-center sticky-top"
            >
                <a
                        href="#"
                        class="d-block p-3 link-light text-decoration-none"
                        title=""
                        data-bs-toggle="tooltip"
                        data-bs-placement="right"
                        data-bs-original-title="Icon-only"
                        onClick="hashPageRequest(0)"
                >
                    <i class="bi-bootstrap h2"></i>
                </a>
                <hr />
                <ul
                        class="nav nav-pills nav-flush flex-sm-column flex-row flex-nowrap mb-auto mx-auto text-center justify-content-between w-100 px-3 align-items-center"
                >
                    <li>
                        <a
                                href="#quiz"
                                class="nav-link py-3 px-2"
                                title=""
                                data-bs-toggle="tooltip"
                                data-bs-placement="right"
                                data-bs-original-title="quiz"
                                onClick="hashPageRequest(1)"
                        >
                            <i class="bi bi-card-heading text-light h2"></i>
                        </a>
                    </li>
                    <li>
                        <a
                                href="#database"
                                class="nav-link py-3 px-2"
                                title=""
                                data-bs-toggle="tooltip"
                                data-bs-placement="right"
                                data-bs-original-title="database"
                                onClick="hashPageRequest(2)"
                        >
                            <i class="bi-table text-light h2"></i>
                        </a>
                    </li>
                    <li>
                        <a
                                href="#user"
                                class="nav-link py-3 px-2"
                                title=""
                                data-bs-toggle="tooltip"
                                data-bs-placement="right"
                                data-bs-original-title="user"
                                onClick="hashPageRequest(3)"
                        >
                            <i class="bi-people text-light h2"></i>
                        </a>
                    </li>
                    <li>
                        <a
                                href="/logout"
                                class="nav-link py-3 px-2"
                                title=""
                                data-bs-toggle="tooltip"
                                data-bs-placement="right"
                                data-bs-original-title="Logout"
                        >
                            <i class="bi bi-power text-light h2"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-sm p-3 min-vh-100">
            <div class="content home">
                <h2>Welcome to quiz system dashboard!</h2>
                <hr />
                <h3>More content...</h3>
                <p>Dashboard</p>
            </div>
            <div class="content quiz">
                <c:import url="./dashboard/dashboard_quiz.jsp" />
            </div>
            <div class="content database">
                <h1>Database</h1>
            </div>
            <div class="content user">
                <h1>User</h1>
            </div>
        </div>
    </div>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"
></script>
<script><%@include file="script/dashboard.js"%></script>
</body>
</html>
