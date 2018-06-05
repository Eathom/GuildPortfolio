<%-- 
    Document   : result
    Created on : Apr 13, 2018, 4:01:21 PM
    Author     : Lizz
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Results </title>
    </head>
    <body>
        <h1>Flooring Results</h1>
        
        <p>
            Total material cost is ${mtrlCost}.
        </p>
        <p>Total labor cost is ${laborCost}.</p>
        <p>Total time is ${hours} hours and ${minutes} minutes.</p>
        <p>Grand total is ${totalCost}.</p>
        
        <p><a href="index.jsp"> Recalculate </a></p>
    </body>
</html>
