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
        <h2>Quiz Information</h2>
    </div>
</div>
<table
        class="table table-striped table-hover custom-table"
        style="font-size: 16px"
>
    <thead>
    <tr class="table-dark text-center">
        <th scope="col">#</th>
        <th scope="col">Date</th>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Score</th>
        <th scope="col">Quiz Type</th>
        <th scope="col">Detail</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="quizTable" items="${quizTable}">
        <tr class="text-center">
            <th scope="row"><c:out value="${quizTable.id}"/></th>
            <td><c:out value="${quizTable.date}"/></td>
            <td><c:out value="${quizTable.firstName}"/></td>
            <td><c:out value="${quizTable.lastName}"/></td>
            <td><c:out value="${quizTable.score}"/></td>
            <td><c:out value="${quizTable.type}"/></td>
            <td>
                <a class="editStatus me-2" title="Edit" data-toggle="tooltip" href="/dashboard/getSubmission?id=${quizTable.id}"><i class="bi bi-folder2-open text-dark"></i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>