<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<%--    <link rel="stylesheet" href="./style.css" />--%>
    <style><%@include file="dashboard_user.css"%></style>
</head>
<body>
<div class="row m-2">
    <div class="col d-flex justify-content-start">
        <h2>Users Information</h2>
    </div>
    <div class="col d-flex justify-content-end">
        <button
                type="button"
                class="btn btn-dark add-new"
                data-bs-toggle="modal"
                data-bs-target="#addUserModal"
        >
            <i class="bi bi-plus" style="font-size: 20px"></i>
        </button>
    </div>
</div>
<table
        class="table table-striped table-hover custom-table"
        style="font-size: 16px"
>
    <thead>
    <tr class="table-dark text-center">
        <th scope="col">#</th>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Address</th>
        <th scope="col">Email</th>
        <th scope="col">Phone</th>
        <th scope="col">Active</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
<%--    <tr class="text-center">--%>
<%--        <th scope="row">1</th>--%>
<%--        <td>Bob</td>--%>
<%--        <td>Otto</td>--%>
<%--        <td>2222 W 100 S, Suite 330, Boston, MA</td>--%>
<%--        <td>admin@example.com</td>--%>
<%--        <td>1234567890</td>--%>
<%--        <td>--%>
<%--            <a class="editStatus" title="Edit" data-toggle="tooltip" onclick="changeIcon(this)"><i class="bi bi-check-circle text-dark"></i></a>--%>
<%--        </td>--%>
<%--        <td>--%>
<%--            <a class="edit me-2" title="EditStatus" data-toggle="tooltip" data-bs-toggle="modal" data-bs-target="#editUserModal" onClick="editUser(this)"--%>
<%--            ><i class="bi bi-pencil-square text-dark"></i--%>
<%--            ></a>--%>
<%--            <a class="delete" title="Delete" data-toggle="tooltip" onClick="deleteRow(this)"--%>
<%--            ><i class="bi bi-person-dash text-dark"></i--%>
<%--            ></a>--%>
<%--        </td>--%>
<%--    </tr>--%>
    <c:forEach var="user" items="${users}">
        <tr class="text-center">
            <th scope="row"><c:out value="${user.userId}"/></th>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.address}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.phone}"/></td>
            <td>
                <a class="editStatus me-2" title="Edit" data-toggle="tooltip" onclick="changeIcon(this)"><i class="bi bi-check-circle text-dark"></i></a>
            </td>
            <td>
                <a class="edit me-2" title="EditStatus" data-toggle="tooltip" data-bs-toggle="modal" data-bs-target="#editUserModal" onClick="editUser(this)"
                ><i class="bi bi-pencil-square text-dark"></i
                ></a>
                <a class="delete" title="Delete" data-toggle="tooltip" onClick="deleteRow(this)"
                ><i class="bi bi-person-dash text-dark"></i
                ></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Modal -->
<!-- ADD Modal -->
<div
        class="modal fade"
        id="addUserModal"
        tabindex="-1"
        aria-labelledby="editUserModalLabel"
        aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="addUserModalLabel">Add User</h1>
                <button
                        type="button"
                        class="btn-close"
                        data-bs-dismiss="modal"
                        aria-label="Close"
                ></button>
            </div>
            <div class="modal-body">
                <form:form id="addUserForm" class="addUserForm" action="/dashboard/addUser" method="post" modelAttribute="hibernateUser">
                    <div class="mb-3">
                        <form:label path="firstName" for="firstName" class="col-form-label">First Name</form:label>:
                        <form:input path="firstName" type="text" class="form-control" id="firstName" />
                    </div>
                    <div class="mb-3">
                        <form:label path="lastName" for="lastName" class="col-form-label">Last Name</form:label>:
                        <form:input path="lastName" type="text" class="form-control" id="lastName" />
                    </div>
                    <div class="mb-3">
                        <form:label path="address" for="address" class="col-form-label">Address</form:label>:
                        <form:input path="address" type="text" class="form-control" id="address" />
                    </div>
                    <div class="mb-3">
                        <form:label path="email" for="email" class="col-form-label">Email</form:label>:
                        <form:input path="email" type="email" class="form-control" id="email" />
                    </div>
                    <div class="mb-3">
                        <form:label path="phone" for="phone" class="col-form-label">Phone</form:label>:
                        <form:input path="phone" type="text" class="form-control" id="phone" />
                    </div>
                    <div class="mb-3">
                        <form:label path="password" for="password" class="col-form-label">Password</form:label>:
                        <form:input path="password" type="password" class="form-control" id="password" />
                    </div>
                </form:form>
            </div>
            <div class="modal-footer">
                <button
                        type="button"
                        class="btn btn-secondary"
                        data-bs-dismiss="modal"
                >
                    Close
                </button>
                <button type="submit" class="btn btn-dark" data-bs-dismiss="modal" onClick="addUser();document.getElementById('addUserForm').submit()">Save</button>
            </div>
        </div>
    </div>
</div>
<!-- EDIT Modal -->
<div
        class="modal fade"
        id="editUserModal"
        tabindex="-1"
        aria-labelledby="editUserModalLabel"
        aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="editUserModalLabel">Edit User</h1>
                <button
                        type="button"
                        class="btn-close"
                        data-bs-dismiss="modal"
                        aria-label="Close"
                ></button>
            </div>
            <div class="modal-body">
                <form:form id="updateUserForm" class="updateUserForm" action="/dashboard/updateUser" method="post">
                    <div class="mb-3">
                        <label for="editFirstName" class="col-form-label">First Name</label>:</label>
                        <input type="text" class="form-control" id="editFirstName" required>
                    </div>
                    <div class="mb-3">
                        <label for="editLastName" class="col-form-label">Last Name</label>:</label>
                        <input type="text" class="form-control" id="editLastName" required>
                    </div>
                    <div class="mb-3">
                        <label for="editAddress" class="col-form-label">Address</label>:</label>
                        <input type="text" class="form-control" id="editAddress">
                    </div>
                    <div class="mb-3">
                        <label for="editEmail" class="col-form-label">Email</label>:</label>
                        <input type="email" class="form-control" id="editEmail" required>
                    </div>
                    <div class="mb-3">
                        <label for="editPhone" class="col-form-label">Phone</label>:</label>
                        <input type="text" class="form-control" id="editPhone">
                    </div>
                </form:form>
            </div>
            <div class="modal-footer">
                <button
                        type="button"
                        class="btn btn-secondary"
                        data-bs-dismiss="modal"
                >
                    Close
                </button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal" onclick="saveUser()">Save</button>
            </div>
        </div>
    </div>
</div>
<script
        src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
<%--<script src="./script.js"></script>--%>
<script><%@include file="dashboard_user.js"%></script>
</body>
</html>
