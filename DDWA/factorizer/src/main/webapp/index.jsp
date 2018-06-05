<%-- 
    Document   : index
    Created on : Apr 13, 2018, 10:55:34 AM
    Author     : Lizz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizer</title>
    </head>
    <body>
        <h1>Factorizer</h1>
        <p> Please enter a number to factor </p>
        <p>
        <form method="POST" action="FactorizerServlet">
            <input type="text" name="numberToFactor">
            <input type="submit" value="Find Factors"> 
        </form>
    </p>
</body>
</html>
