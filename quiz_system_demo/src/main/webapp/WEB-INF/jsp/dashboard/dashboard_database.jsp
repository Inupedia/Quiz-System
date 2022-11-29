<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <style>
        .custom-table {
            border: 1px solid #dee2e6;
            border-radius: 0.25rem;
            overflow: hidden;
            width: 100%;
            margin-bottom: 1rem;
            background-color: #fff;
            background-clip: border-box;
        }
    </style>
</head>
<body>
<div class="row m-2">
    <div class="col d-flex justify-content-start">
        <h2>Reviews</h2>
    </div>
</div>
<table
        class="table table-striped table-hover custom-table"
        style="font-size: 16px"
>
    <thead>
    <tr class="table-dark text-center">
        <th scope="col">#</th>
        <th scope="col">Quiz Type</th>
        <th scope="col">Rating</th>
        <th scope="col">Comment</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="reviewTable" items="${reviewTable}">
        <tr class="text-center">
            <th scope="row"><c:out value="${reviewTable.id}"/></th>
            <td><c:out value="${reviewTable.type}"/></td>
            <td><c:out value="${reviewTable.rate}"/></td>
            <td><c:out value="${reviewTable.comment}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>