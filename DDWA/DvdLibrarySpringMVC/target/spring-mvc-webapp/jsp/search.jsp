<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Search Results</h1>
            <hr/>




            <div class="container">
                <div class="row">
                    <ul class="list-group" id="errorMessages">
                        <!-- DYNAMICALLY INSERT LI ERROR MESSAGES HERE -->
                    </ul>
                </div>
                <div class="col-md-6">
                    <table id="dvdTable" class="table table-hover">
                        <tr>
                            <th width="40%">Title</th>
                            <th width="30%">Rating</th>
                            <th width="15%">Release Date</th>
                            <th width="15%">Director</th>
                        </tr>
                        <tbody id="contentRows">
                            
                        </tbody>
                    </table>
                </div>
                
                <div class="col-md-6">
                    
                        <h2>Search</h2>
                        <form class="form-horizontal" id="search-dvd-form" role="form">
                           

                            <div class="col-md-4 form-group">
                                <button type="button" class="btn btn-default" onclick="search()" role="button"> Search</button>
                            </div>

                            <div class="col-md-4 form-group">
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

                            <div class="col-md-4 form-group">
                                <div class="col-md-10">

                                    <input type="text" class="form-control" id="search-term" placeholder="Search Term" required/>
                                </div>
                            </div>

                        </form>
                   
                </div>


          


                </div>
















            </div>



        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/search.js"></script>

    </body>
</html>

