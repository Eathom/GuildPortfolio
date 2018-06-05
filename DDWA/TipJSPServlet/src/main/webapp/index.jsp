<%-- 
    Document   : index
    Created on : Apr 14, 2018, 9:34:08 PM
    Author     : Lizz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>
        <form method="POST" action="TipServlet">
            Bill amount: <input type="text" name="bill"/><br>
            Percentage to tip: <input type="text" name="tip"/><br>
             <input type="submit" value="Calculate"/><br>
        </form>
        </p>
    </body>
</html>
