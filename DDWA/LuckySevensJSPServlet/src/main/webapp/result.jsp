<%-- 
    Document   : result
    Created on : Apr 16, 2018, 8:34:14 AM
    Author     : Lizz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens End Game</title>
    </head>
    <body>
        <h1>Lucky Sevens End Game</h1>
        <p>
            You bet $${input}.
        </p>
         <p>
            You are broke after ${countRoll} rolls.
        </p>
         <p>
            You should have quit after ${rollWithMaxMoney} rolls when you had $${maximumMoney}.
        </p>
        <p>
            <a href="index.jsp"> Play Again</a>
        </p>
    </body>
</html>
