<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
    <style><%@include file="style/submission.css"%></style>
</head>
<body>
<div class="d-flex justify-content-center result-board m-4 ">
    <p></p>
</div>
<div class="quiz m-4">
    <Form>
        <c:forEach items="${data}" var="data">
            <div class="tab mt-4">
                <div class="question">
                    <p>${data.index}. ${data.question.description}</p>
                </div>
                <c:forEach items="${data.options}" var="answer">
                    <c:choose>
                        <c:when test="${data.userAnswer==answer.description and data.userAnswer==data.question.correctAnswer}">
                            <div class="form-check box correct">
                                <input class="form-check-input" type="radio" name="${data.question.questionId}" id="q${data.question.questionId}o${answer.optionId}" value="${answer.description}" checked disabled/>
                                <label class="form-check-label ms-2 w-100" for="q${data.question.questionId}o${answer.optionId}" disabled>${answer.description}</label>
                            </div>
                        </c:when>
                        <c:when test="${data.userAnswer==answer.description and data.userAnswer!=data.question.correctAnswer}">
                            <div class="form-check box incorrect">
                                <input class="form-check-input" type="radio" name="${data.question.questionId}" id="q${data.question.questionId}o${answer.optionId}" value="${answer.description}" checked disabled/>
                                <label class="form-check-label ms-2 w-100" for="q${data.question.questionId}o${answer.optionId}" disabled>${answer.description}</label>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="form-check box">
                                <input class="form-check-input" type="radio" name="${data.question.questionId}" id="q${data.question.questionId}o${answer.optionId}" value="${answer.description}" disabled/>
                                <label class="form-check-label ms-2 w-100" for="q${data.question.questionId}o${answer.optionId}" disabled>${answer.description}</label>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
        </c:forEach>
        <div style="overflow:auto;" class="mt-4">
            <div style="float:right;">
                <a type="button" id="feedbackBtn" href="/dashboard" class="btn btn-dark">Back</a>
            </div>
        </div>
    </Form>
</div>
</body>
</html>