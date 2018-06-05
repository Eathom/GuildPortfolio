<%-- 
    Document   : result
    Created on : Apr 14, 2018, 9:34:15 PM
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
            Amount: ${bill}<br>
            Tip: ${tipPercent}<br>
            Tip Amount: ${tipAmount}<br>
            Total Bill: ${total}<br>
            <a href="index.jsp">Recalculate</a>
        </p>
    </body>
</html>
