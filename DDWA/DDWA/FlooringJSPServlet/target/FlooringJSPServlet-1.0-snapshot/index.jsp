<%-- 
    Document   : index
    Created on : Apr 13, 2018, 4:01:14 PM
    Author     : Lizz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Calculator</title>
    </head>
    <body>
        <h1>Flooring Calculator</h1>
        <p>
        <form method="POST" action="FlooringServlet">
            <p>  Enter floor width <input type="text" name="width"></p>
            <p> Enter floor length <input type="text" name="length"></p>
            <p>   Enter cost/sq ft <input type="text" name="cost"></p>
            <p> <input type="submit" value="Calculate">
            
        </form>
        </p>
    </body>
</html>
