<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Personal Stats</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/viewStats-style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer-style.css">
    </head>

    <body>
  
        <div class="class1">
        <form class="display-inline" name="home" action="${pageContext.request.contextPath}/home" method="POST">
            <input class="btn btn-success" type="submit" value="Home"/>
        </form>        
        <form class="display-inline" action="${pageContext.request.contextPath}/appLogout" method="POST">
            <input class="btn btn-danger" type="submit" value="Log Out"/>
        </form>

        <h3>Username: ${username}</h3>
        <p class="class2" >Rank: ${rank}</p>
        <p class="class2" >Took ${beginnerCount} beginner quizzes and averaged a : ${beginnerScore}</p>
        <p class="class2" >Took ${intermediateCount} intermediate quizzes and averaged a : ${intermediateScore}</p>
        <p class="class2" >Took ${advancedCount} advanced quizzes and averaged a : ${advancedScore}</p>
        </div>
        
        <%@ include file="/WEB-INF/views/footer.jsp" %>
    </body>
</html>
