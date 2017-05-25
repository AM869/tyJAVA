<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session = "false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Registration Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer-style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/registration-style.css">
    </head>
    <body> 
        
        <springForm:form   action="${pageContext.request.contextPath}/register" method="POST" modelAttribute="registrationBean">
            
            <table>

                <tr>
                    <td>USERNAME: </td>
                                
                    <td><springForm:input type="text" path="username" size="20" maxlength="50" required="true"/></td>
                    
                    <td><springForm:errors path="username" cssClass="error" /></td>
                    
                    <td>
                        <c:if test="${usernameExists !=null}">
                            <span class="error" >${usernameExists}</span>
                        </c:if>
                    </td>                
                </tr>
                
            
                <tr>
                    <td>PASSWORD: </td>
                
                    <td><springForm:input type="password" path="password" size="20" maxlength="50" required="true"/></td>
                
                    <td><springForm:errors path="password" cssClass="error" />
                        
                </tr>
                
            
                <tr>
                    <td>confirm PASSWORD:</td> 

                    <td><springForm:input type="password" path="confirmPassword" size="20" maxlength="50" required="true"/></td>

                    <td><springForm:errors path="confirmPassword" cssClass="error" /></td>
                </tr>
            
                
                <tr>
                    <td>E-MAIL:</td> 
                
                    <td><springForm:input type="email" path="email" size="20" maxlength="50" required="true"/></td>
                
                    <td><springForm:errors path="email" cssClass="error" /></td>
                </tr>
            
                
                <tr>
                    <td>confirm E-MAIL: </td>

                    <td><springForm:input type="email" path="confirmEmail" size="20" maxlength="50" required="true"/></td>
                    
                    <td><springForm:errors path="confirmEmail" cssClass="error" /></td>
                </tr>
            
                
                <tr>
                    <td><input type="reset" value="Reset" id="reset_button"/></td>

                    <td><input type="submit" value="Submit" id="submit_button"/></td>
                </tr>
            
            </table>
                
        </springForm:form>
        
   
    </body>
</html>
