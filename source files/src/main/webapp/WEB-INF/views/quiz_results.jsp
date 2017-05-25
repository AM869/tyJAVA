<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quiz Results</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/quiz_results-style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer-style.css">

        <script type="text/javascript">
            function showHide(){
                var checkbox = document.getElementById("showhide");
                var hideform = document.getElementById("myform");
                if(checkbox.checked == true){
                    hideform.style.display = "block";
                }
                else{
                    hideform.style.display = "none";
                }
            }
        </script>
    </head>

    <body>

        <div class="class1">
            <form class="display-inline" name="home" action="${pageContext.request.contextPath}/home" method="POST">
                <input class="btn btn-success" type="submit" value="Home"/>
            </form>        
            <form class="display-inline" action="${pageContext.request.contextPath}/appLogout" method="POST">
                <input class="btn btn-danger" type="submit" value="Log Out"/>
            </form>

            <div class="div1">${username}</div>
            <c:if test="${rankUp != null}">
            <div class="div1"><span class="green">${rankUp}</span></div>
            </c:if>
            <div class="div2">Answered correctly ${answeredCorrectly} out of 10</div>
            <div class="div2">Left unanswered ${unanswered} out of 10</div>


            <c:if test="${answeredWrongly>0}">

            <div class="div2"><span class="red">Wrongly</span> answered: ${answeredWrongly} out of 10</div>

            <div class="div3"><input type="checkbox" name="show_hide" id="showhide" onclick="showHide()"/>
            <label for="showhide"><u>Show/Hide answers to wrongly answered questions</u></label></div>
            <br/>
            <form id="myform">
                <c:forEach var="wronglyAnsweredQuestion" items="${wronglyAnsweredQuestionList}">
                <div class="div2">${wronglyAnsweredQuestion.questionbody}</div>
                <div class="div3">A. ${wronglyAnsweredQuestion.answer1}</div>
                <div class="div3">B. ${wronglyAnsweredQuestion.answer2}</div>
                <div class="div3">C. ${wronglyAnsweredQuestion.answer3}</div>
                <div class="div3">D. ${wronglyAnsweredQuestion.answer4}</div>
                <div class="div3">Your Answer: <span class="red" >${wronglyAnsweredQuestion.userAnswer}</span></div>
                <div class="div3">Correct Answer: <span class="green">${wronglyAnsweredQuestion.correctanswer}</span></div>
                </br>                               
                </c:forEach>
            </form>      
            </c:if>

        </div>                                   
    </body>
</html>
