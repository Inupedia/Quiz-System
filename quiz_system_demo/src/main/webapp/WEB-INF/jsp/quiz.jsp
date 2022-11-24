<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
    <style><%@include file="style/quiz.css"%></style>
</head>
<body>
<div class="quiz m-4">
    <Form method="post" action="submission">
        <div style="text-align:center;margin-top:20px;margin-bottom:20px">
            <c:forEach items="${data}" var="data">
                <span class="step"></span>
            </c:forEach>
        </div>
        <c:forEach items="${data}" var="data">
            <div class="tab">
                <div class="question">
                    <p>${data.index}. ${data.question.description}</p>
                </div>
                <c:forEach items="${data.options}" var="answer">
                    <div class="form-check box">
                        <input class="form-check-input" type="radio" name="${data.question.id}" id="q${data.question.id}o${answer.id}" value="${answer.optionDescription}" />
                        <label class="form-check-label ms-2 w-100" for="q${data.question.id}o${answer.id}">${answer.optionDescription}</label>
                    </div>
                    <%--            <p>${answer.optionDescription}</p>--%>
                </c:forEach>
            </div>
        </c:forEach>
<%--        <div class="d-flex justify-content-end mt-4">--%>
<%--            <button type="submit" class="btn btn-dark">Next</button>--%>
<%--        </div>--%>
        <div style="overflow:auto;" class="mt-4">
            <div style="float:right;">
                <button type="button" id="prevBtn" onclick="nextPrev(-1)" class="btn btn-light">Previous</button>
                <button type="button" id="nextBtn" onclick="nextPrev(1)" class="btn btn-dark">Next</button>
            </div>
        </div>
    </Form>
</div>
<script><%@include file="script/quiz.js"%></script>
</body>
</html>

