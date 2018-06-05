<%-- 
    Document   : result
    Created on : Apr 18, 2018, 7:13:18 PM
    Author     : Lizz
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Result</h1>
        <p>
            You bet: ${input} <br>
            You are broke after ${countRoll} <br>
            You should have quit after ${rollWithMaxMoney} when you had $ ${maximumMoney}
        </p>
        <a href="index.jsp"> Play again </a>
    </body>
</html>
