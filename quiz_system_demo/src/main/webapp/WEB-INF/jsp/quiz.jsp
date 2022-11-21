<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <style>
       .box {
           display: flex;
           margin-top:10px;
           padding: 10px 12px;
           border-radius: 5px;
           border: 1px solid #ccc;
           /*border-color: #212529;*/
       }
       .form-check .form-check-input {
           margin-left: 0px;
       }
    </style>
</head>
<div class="quiz m-4">
<%--    <ul class="list-group">--%>
<%--        <div class="question">--%>
<%--            <p>1. What is the capital of France?</p>--%>
<%--        </div>--%>
<%--        <li class="list-group-item">--%>
<%--            <input type="radio" name="question-1-answers" id="question-1-answers-A" value="A" />--%>
<%--            <label for="question-1-answers-A">A) London </label>--%>
<%--        </li>--%>
<%--        <li class="list-group-item">--%>
<%--            <input type="radio" name="question-1-answers" id="question-1-answers-B" value="B" />--%>
<%--            <label for="question-1-answers-B">B) Paris </label>--%>
<%--        </li>--%>
<%--        <li class="list-group-item">--%>
<%--            <input type="radio" name="question-1-answers" id="question-1-answers-C" value="C" />--%>
<%--            <label for="question-1-answers-C">C) Dublin</label>--%>
<%--        </li>--%>
<%--        <li class="list-group-item">--%>
<%--            <input type="radio" name="question-1-answers" id="question-1-answers-D" value="D" />--%>
<%--            <label for="question-1-answers-D">D) Moscow</label>--%>
<%--        </li>--%>
<%--    </ul>--%>
<%--    List<Data> data = new ArrayList<>();
        data.add(new Data("What is the capital of India?", new ArrayList<String>() {{
            add("Delhi");
            add("Mumbai");
            add("Kolkata");
            add("Chennai");
        }})); --%>
<Form method="post" action="api/submission">
    <%--    List<Data> data = new ArrayList<>();
        data.add(new Data("What is the capital of India?", new ArrayList<String>() {{
            add("Delhi");
            add("Mumbai");
            add("Kolkata");
            add("Chennai");
        }})); --%>
    <c:forEach items="${data}" var="data">
        <div class="question">
            <p>${data.question.description}</p>
        </div>
        <c:forEach items="${data.answers}" var="answer">
            <div class="form-check box">
                <input class="form-check-input" type="radio" name="option" id="q${data.question.id}o${answer.id}" value="${answer.optionDescription}" />
                <label class="form-check-label ms-2 w-100" for="q${data.question.id}o${answer.id}">${answer.optionDescription}</label>
            </div>
            <%--            <p>${answer.optionDescription}</p>--%>
        </c:forEach>
    </c:forEach>
    <div class="d-flex justify-content-end mt-4">
        <button type="submit" class="btn btn-dark">Submit</button>
    </div>
</Form>
</div>
