
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session = "false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>General Info</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/css/footer-style.css">
        <style>
            body{
                padding:10px;
            }
        </style>
    </head>
    <body>
        
        <SECTION>
        
        <h1>TY JAVA</h1>
        <h3>This site contains java quizzes. The purpose of these quizzes is to test mostly one's level of involvement with java programming language and are easy to answer because they are mainly theoretical.</h3>
        <h3>-The user will have two and a half minutes to answer any quiz.</h3>
        <h3>-There are three quiz categories beginner, intermediate, advanced</h3>
        <h3>-The user cant start with beginner quizzes and once he/she accumulates a good score(average score >=8, from quizzes of the same category) after taking one or more quizzes, can advance to next rank.</h3>
        <h3>-After each quiz the user will be able to see where his/her mistakes were only on those questions he/she answered wrongly and not the ones he/she left unanswered.</h3>        
        <br><br>
       
        <h3>email: klsoukas@gmail.gr, cell: +30 6930420805</h3>
        
        </SECTION>
        
        
        <form action="${pageContext.request.contextPath}/" method="GET">
            <input class="btn btn-success" type="submit" value="HOME" />
        </form>
        
        <%@include file="/WEB-INF/views/footer.jsp" %>
    </body>
</html>
