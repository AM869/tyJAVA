<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session = "false"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login Page</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/css/footer-style.css">
        <link rel="stylesheet" type="text/css" href="resources/css/login-style.css">
    </head>
    <body>
        
        <h1><span>Test your</span> Java <span>knowledge</span></h1>
        <div class="container-fluid" >
            <div class ="row">  
                <div class="col-xs-6">
                <form class="pad" action="${pageContext.request.contextPath}/registration" name="log-in form" method="GET">
                    <input class="btn btn-info" type="submit" value="REGISTER HERE" />
                </form>
                </div>

                <div  class="col-xs-6">
                    <div class="info" ><a href="${pageContext.request.contextPath}/info">Info-Instructions-Contact</a></div>    
                </div>
            </div>

                
            <c:if test="${not empty param.registration}">            
                <div class="success">Registration Successful for user ${param.username}!</div>
            </c:if>

                
            <div class="row" >
                <div class="col-xs-12">
                    <c:url var="loginProccessingUrl" value="/appLogin"></c:url>
                    <form action="${loginProccessingUrl}" name="log-in form" method="POST">
                        <fieldset>                
                        <legend>Already registered?</legend>
                            USERNAME:<br>
                            <input type="text" name="username" size="30" required maxlength="50">
                            <br>
                            <br>
                            PASSWORD:<br>
                            <input type="password" name="password" size="30" required maxlength="50" >
                            <br>
                            <br>               
                            <input type="submit" value="Login" class="btn btn-success">     
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
                        </fieldset>    
                    </form>  
                </div>
                        
                <c:if test="${param.bad_credentials != null}">            
                    <span class="error">Incorrect username or password!</span>
                </c:if>

            </div>
            
        </div>
        
        
        <%@include file="/WEB-INF/views/footer.jsp" %>
    </body>
</html>
