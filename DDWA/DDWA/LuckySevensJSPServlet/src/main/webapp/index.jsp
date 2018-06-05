<%-- 
    Document   : index
    Created on : Apr 16, 2018, 8:33:58 AM
    Author     : Lizz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens</title>
    </head>
    <body>
        <h1>Lucky Sevens</h1>
        <form method="POST" action="LuckySevensServlet">
            <p> 
                For every dice roll that equals 7, you win $4.<br>
                Any other roll, you lose $1. 
            </p>
            <p>
                Enter the amount of money to bet. <br>
                $<input type="text" name="betAmount"/> 
            </p>
            <p>
                <input type="submit" value="Roll Dice"/>
            </p>
        </form>
    </body>
</html>
