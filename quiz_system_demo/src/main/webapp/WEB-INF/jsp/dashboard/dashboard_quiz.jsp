<head>
    <title>Dashboard</title>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
            integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
            crossorigin="anonymous"
    />
    <style><%@include file="./dashboard_quiz.css"%></style>
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
    <tr class="text-center">
        <th scope="row">1</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>2222 W 100 S, Suite 330, Boston, MA</td>
        <td>admin@example.com</td>
        <td>1234567890</td>
        <td>
            <a class="editStatus" title="Edit" data-toggle="tooltip" onclick="changeIcon(this)"><i class="bi bi-check-circle text-dark"></i></a>
        </td>
        <td>
            <a class="edit me-2" title="EditStatus" data-toggle="tooltip" data-bs-toggle="modal" data-bs-target="#editUserModal"
            ><i class="bi bi-pencil-square text-dark"></i
            ></a>
            <a class="delete" title="Delete" data-toggle="tooltip" onClick="deleteRow(this)"
            ><i class="bi bi-person-dash text-dark"></i
            ></a>
        </td>
    </tr>
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
                <form class="addUserForm">
                    <div class="mb-3">
                        <label for="firstName" class="col-form-label">First Name</label>:</label>
                        <input type="text" class="form-control" id="firstName" required>
                    </div>
                    <div class="mb-3">
                        <label for="lastName" class="col-form-label">Last Name</label>:</label>
                        <input type="text" class="form-control" id="lastName" required>
                    </div>
                    <div class="mb-3">
                        <label for="address" class="col-form-label">Address</label>:</label>
                        <input type="text" class="form-control" id="address">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="col-form-label">Email</label>:</label>
                        <input type="email" class="form-control" id="email" required>
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="col-form-label">Phone</label>:</label>
                        <input type="text" class="form-control" id="phone">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="col-form-label">Password</label>:</label>
                        <input type="password" class="form-control" id="password" required>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button
                        type="button"
                        class="btn btn-secondary"
                        data-bs-dismiss="modal"
                >
                    Close
                </button>
                <button type="button" class="btn btn-dark" data-bs-dismiss="modal" onClick="addUser()">Save</button>
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
                <form>
                    <div class="mb-3">
                        <label for="editFirstName" class="col-form-label">First Name</label>:</label>
                        <input type="text" class="form-control" id="editFirstName" value="Alex" required>
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
                </form>
            </div>
            <div class="modal-footer">
                <button
                        type="button"
                        class="btn btn-secondary"
                        data-bs-dismiss="modal"
                >
                    Close
                </button>
                <button type="button" class="btn btn-dark">Save</button>
            </div>
        </div>
    </div>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"
></script>
<script><%@include file="./dashboard_quiz.js"%></script>