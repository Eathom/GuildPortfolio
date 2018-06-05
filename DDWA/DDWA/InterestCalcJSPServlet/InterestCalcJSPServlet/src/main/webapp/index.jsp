<%-- 
    Document   : index
    Created on : Apr 14, 2018, 7:28:09 PM
    Author     : Lizz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Calc</title>
    </head>
    <body>
        <h1>Interest Calc</h1>
        <p>
        <form method="POST" action="InterestServlet">
            <p>Input Annual Interest Rate <input type="text" name="interest"/><br>
                Input principle amount <input type="text" name="principle"/><br>
                Input no. of years to calculate 
                <input type="text" name="years"/><br>
            <input type="submit" value="Calculate Interest"/></p></form>
    </body>
</html>
