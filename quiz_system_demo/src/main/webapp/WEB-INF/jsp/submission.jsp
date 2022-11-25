<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Home</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
        <style><%@include file="style/submission.css"%></style>
    </head>
    <body>
        <div class="result-board">
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
                                <c:when test="${data.userAnswer==answer.optionDescription and data.userAnswer==data.question.correctAnswer}">
                                    <div class="form-check box correct">
                                        <input class="form-check-input" type="radio" name="${data.question.id}" id="q${data.question.id}o${answer.id}" value="${answer.optionDescription}" checked disabled/>
                                        <label class="form-check-label ms-2 w-100" for="q${data.question.id}o${answer.id}" disabled>${answer.optionDescription}</label>
                                    </div>
                                </c:when>
                                <c:when test="${data.userAnswer==answer.optionDescription and data.userAnswer!=data.question.correctAnswer}">
                                    <div class="form-check box incorrect">
                                        <input class="form-check-input" type="radio" name="${data.question.id}" id="q${data.question.id}o${answer.id}" value="${answer.optionDescription}" checked disabled/>
                                        <label class="form-check-label ms-2 w-100" for="q${data.question.id}o${answer.id}" disabled>${answer.optionDescription}</label>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="form-check box">
                                        <input class="form-check-input" type="radio" name="${data.question.id}" id="q${data.question.id}o${answer.id}" value="${answer.optionDescription}" disabled/>
                                        <label class="form-check-label ms-2 w-100" for="q${data.question.id}o${answer.id}" disabled>${answer.optionDescription}</label>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </div>
                </c:forEach>
                <div style="overflow:auto;" class="mt-4">
                    <div style="float:right;">
                        <button type="button" id="retakeBtn" onclick="retake()" class="btn btn-dark">Retake</button>
                        <button type="button" id="feedbackBtn" onclick="submitFeedback()" class="btn btn-dark">FeedBack</button>
                    </div>
                </div>
            </Form>
        </div>
<%--        <form action="feedback" method="get">--%>
<%--            <input type="submit" value="Submit Feedback">--%>
<%--        </form>--%>

<%--        <form action="home" method="get">--%>
<%--            <input type="submit" value="Home">--%>
<%--        </form>--%>
        <script><%@include file="script/submission.js"%></script>
        <script>
            showTab(${score}, ${totalScore});
        </script>
    </body>
</html>