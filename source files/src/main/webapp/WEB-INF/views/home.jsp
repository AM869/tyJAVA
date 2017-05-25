<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home page</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/css/footer-style.css">
        <link rel="stylesheet" href="resources/css/home-style.css">
    </head>
    
    <body>
        <h2>Welcome ${username}! <a id="info" href="${pageContext.request.contextPath}/info">Info-Contact</a> </h2>    
          
        <c:url var="logoutProccessingUrl" value="/appLogout"></c:url>
        <form action="${logoutProccessingUrl}" method="POST">
        <input class="btn btn-danger" type="submit" value="Logout"/>	
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
        </form>
        
            
        <form action="${pageContext.request.contextPath}/beginner_quiz" method="GET">
            <button class="buttons btn btn-primary" name="quiz" type="submit" value="beginner_quiz">TAKE A BEGINNER QUIZ</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/intermediate_quiz" method="GET">
            <button class="buttons btn btn-primary" name="quiz" type="submit" value="intermediate_quiz">TAKE AN INTERMEDIATE QUIZ</button>
        </form>
        
        <form action="${pageContext.request.contextPath}/advanced_quiz" method="GET">
            <button class="buttons btn btn-primary" name="quiz" type="submit" value="advanced_quiz">TAKE AN ADVANCED QUIZ</button>
        </form>
        
        <br><br>
        <form name="stats" action="${pageContext.request.contextPath}/view_stats" method="POST">
            <input class ="btn btn-warning" type="submit" value="View Stats" />
        </form>
        <div>
        <c:if test="${param.access_denied != null}">
            <span class="error">Access Denied! You have to increase your score on the lower difficulty quizzes first.</span>
            
        </c:if>
        </div>
        
        <%@include file="/WEB-INF/views/footer.jsp" %>

    </body>
</html>
