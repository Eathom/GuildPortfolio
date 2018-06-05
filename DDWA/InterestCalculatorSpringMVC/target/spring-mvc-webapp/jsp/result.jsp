<%-- 
    Document   : result
    Created on : Apr 18, 2018, 6:39:46 PM
    Author     : Lizz
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Interest Forecast</title>
    </head>
    <body>
        <h1>Interest Forecast</h1>
        
        <c:forEach var="currentYearInfo" items="${YearlyObjects}">
            <p>
                Current yr #: ${currentYearInfo.currentYear}<br>
                <c:choose>
                    <c:when test="${currentYearInfo.currentYear == 1}">
                        Starting Balance: ${currentYearInfo.startingPrinciple}<br>
                    </c:when>
                    <c:otherwise>
                        Starting Balance: ${currentYearInfo.carryOverPrinciple}<br>
                    </c:otherwise>
                </c:choose>
                
                
                Interest Earned: ${currentYearInfo.interestGained}<br>
                Ending principle: ${currentYearInfo.endingPrinciple}<br>
                
            </p>
        </c:forEach>
         
    </body>
</html>
