<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Flooring Calc</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Flooring Calc</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                	<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                	<li role="presentation"><a href="${pageContext.request.contextPath}/hello/sayhi">Hello Controller</a></li>
                </ul>    
            </div>
            <h2>Enter flooring info</h2>
            <form method="POST" action="calculate">
                Floor width:   <input type="text" name="width"/><br>
                Floor length: <input type="text" name="length"/><br>
                Cost/sq ft: <input type="text" name="cost"/><br>
                <input type="submit" value="Get Cost"/>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

