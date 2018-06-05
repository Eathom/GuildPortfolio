<%-- 
    Document   : result
    Created on : Apr 18, 2018, 6:11:50 PM
    Author     : Lizz
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Flooring Invoice</title>
    </head>
    <body>
        <h1>Flooring Invoice</h1>
        <p>
            Width: ${width}
        </p>
        <p>
            Length: ${length}
        </p>
        <p>
            Cost: ${cost}
        </p>
        <p>
            Materials: ${mtrlCost}
            Labor: ${laborCost}
            Hours: ${Hours} Minutes: ${minutes}
            Grand Total: ${totalCost}
        </p>
        <a href="index.jsp"> Try again </a>
    </body>
</html>
