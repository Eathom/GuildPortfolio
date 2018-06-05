<%-- 
    Document   : create
    Created on : Apr 29, 2018, 5:03:26 PM
    Author     : Lizz
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Create</title>
    </head>
    <body>
       
            <h1>Create Dvd:
            </h1>
            <hr/>
           
            <form class="form-horizontal" id="add-form" role="form"  action="addDvd" method="POST">
                <div class=" form-group">
                    <label for="add-title" class="control-label.text-left col-md-2">Title: </label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="add-title"
                                  name="title" placeholder="title"/>
                      
                    </div>
                </div>

                <div class=" form-group">
                    <label for="add-date" class="control-label.text-left col-md-2">Release Date: </label>
                    <div class="col-md-4">
                        <input type= "text" class="form-control" id="add-date" placeholder="Enter Date" name="rlsDate"/>
                       
                    </div>
                </div>

                <div class=" form-group">
                    <label for="add-rating" class="control-label.text-left col-md-2">Rating: </label>
                    <div class="col-md-4">
                        <input type= "text" class="form-control" id="add-rating" placeholder="Enter rating" name="rating"/>
                       
                    </div>
                </div>

               <div class=" form-group">
                    <label for="add-director" class="control-label.text-left col-md-2">director: </label>
                    <div class="col-md-4">
                        <input type= "text" class="form-control" id="add-director" placeholder="Enter director" name="director"/>
                       
                    </div>
                </div>
                    <div class="form-group">
                         <div class="col-md-1">
                        <input type="submit" class="btn btn-default"  value="Create Dvd"/>
                    </div>
                    </div>
            </form>
    
    <form role="form" method="GET" action="displayIndex"> 
                <div class="form-group">
                    <div class="col-md-1">
                        <button type="submit" class="btn btn-default" role="button"> Cancel </button>
                    </div>
                   
                </div>
    </form>


            
        

    </body>
</html>
