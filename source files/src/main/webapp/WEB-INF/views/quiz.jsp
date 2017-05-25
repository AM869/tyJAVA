<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quiz</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer-style.css">
        <link rel="stylesheet" href="resources/css/quiz-style.css">

    </head>
    <body>
        <h1>Quiz is on!</h1>
        <span id="countdown" class="timer"></span>
            <script>
            var seconds = 150;
            function timePassed() {
                var minutes = Math.round((seconds - 30)/60);
                var remainingSeconds = seconds % 60;
                if (remainingSeconds < 10) {
                    remainingSeconds = "0" + remainingSeconds;  
                }
                document.getElementById('countdown').innerHTML = minutes + ":" + remainingSeconds+" left!";
                if (seconds == 0) {
                    clearInterval(countdownTimer);
                    document.getElementById('countdown').innerHTML = "Time's up!!";
                } else {
                    seconds--;
                }
            }
 
            var countdownTimer = setInterval('timePassed()', 1000);
        </script><br>
        
        <form id="form" name="quiz_form" action="${pageContext.request.contextPath}/submit_quiz" method="POST">
            
            
            <c:forEach var="question" items="${question_list}">
                <div class="question-block">
                    <p class="p1"> ${question.questionbody}</p>

                    <p class="p2"><label><input type="radio" name="${question.id}" value="A"/> ${question.answer1}</label></p>
                    <p class="p2"><label><input type="radio" name="${question.id}" value="B"/> ${question.answer2}</label></p>
                    <p class="p2"><label><input type="radio" name="${question.id}" value="C"/> ${question.answer3}</label></p>
                    <p class="p2"><label><input type="radio" name="${question.id}" value="D"/> ${question.answer4}</label></p>
                </div>
            </c:forEach>
            <input type="submit" id="submit_button" value="Submit Answers" name="submit quiz button"  />
            <script type="text/javascript">var wait=setTimeout("document.quiz_form.submit();",151200);</script>
        </form>       
        
    </body>
</html>
