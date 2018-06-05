<%-- 
    Document   : index
    Created on : Apr 29, 2018, 6:23:06 PM
    Author     : Lizz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Company Contacts</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>

        <div class="container">
            <div class="row">
                <ul class="list-group" id="errorMessages">
                    <!-- DYNAMICALLY INSERT LI ERROR MESSAGES HERE -->
                </ul>
            </div>


            <div class="row">
                <div id="dvdFormDiv">

                      <form class="form-horizontal" id="add-dvd-form" role="form" method="GET" action="displayCreatePage">
                        <div class="col-md-3 form-group">
                            <button type="submit" class="btn btn-default" role="button">Create DVD</button>
                        </div>
                    </form>
                    
                    <form class="form-horizontal" id="search-dvd-form" role="form" method="POST" action="displaySearchPage">
                        <div class="col-md-3 form-group">
                            <button type="submit" class="btn btn-default" role="button"> Search</button>
                        </div>

                        <div class="col-md-3 form-group">
                            <div class="col-md-10">

                                <select class="form-control selectpicker" id="search-category" required>
                                    <option value="">Select Category</option>
                                    <!-- <option value="" selected disabled>Select Category</option> -->
                                    <option value="title">Title</option>
                                    <option value="year">Release Year</option>
                                    <option value="director">Director Name</option>
                                    <option value="rating">Rating</option>
                                </select>
                            </div>
                        </div>

                        <div class="col-md-3 form-group">
                            <div class="col-md-10">

                                <input type="text" class="form-control" id="search-term" placeholder="Search Term" required/>
                            </div>
                        </div>

                    </form>
                </div>
            </div>



            <p>
                DVD Landing page.
            </p>
            <a href="displayTablePage">View library</a>



        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

