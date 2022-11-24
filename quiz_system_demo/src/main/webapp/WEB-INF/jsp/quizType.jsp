<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container mt-4">
    <div class="row">
        <c:forEach var="quizType" items="${quizTypeList}">
            <div class="col-md-4">
                <div class="panel panel-default text-center">
                    <div class="panel-heading">
                        <h3 class="panel-title">${quizType.typeName}</h3>
                    </div>
                    <div class="panel-body">
                        <a href="quiz?quizTypeId=${quizType.id}" class="btn btn-primary">Start</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>