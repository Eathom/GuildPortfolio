<%-- 
    Document   : edit
    Created on : Apr 29, 2018, 5:02:19 PM
    Author     : Lizz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="row">
            
                <h1>Edit Dvd:
                   
                </h1>
                <hr/>
                <sf:form class="form-horizontal" id="edit-form" role="form" modelAttribute="dvd" action="editDvd" method="POST" >
                    <div class=" form-group">
                        <label for="edit-title" class="control-label.text-left col-md-2">Title: </label>
                        <div class="col-md-4">
                            <sf:input type= "text" class="form-control" id="edit-title" path="title"/>
                            <sf:errors path="title" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class=" form-group">
                        <label for="edit-year" class="control-label.text-left col-md-2">Release Year: </label>
                        <div class="col-md-4">
                            <sf:input type= "text" class="form-control" id="edit-rlsDate" path="rlsDate"/>
                            <sf:errors path="rlsDate" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class=" form-group">
                        <label for="edit-director" class="control-label.text-left col-md-2">Director: </label>
                        <div class="col-md-4">
                             <sf:input type= "text" class="form-control" id="edit-director" path="director"/>
                            <sf:errors path="director" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-rating" class="control-label.text-left col-md-2">Rating: </label>
                        <div class="col-md-1">
                            <sf:select class="selectpicker form-control col-md-8" id="edit-rating" path="rating">
                                <option>G</option>
                                <option>PG</option>
                                <option>PG-13</option>
                                <option>R</option>
                            </sf:select>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-md-1">
                            <sf:input type="hidden" id="edit-dvdId" path="dvdId"/>
                            <input type="submit" class="btn btn-default" role="button" value="Save Changes"> </button>
                        </div>
                    </div>
                            </sf:form>
                        
                        <form role="form" action="displayIndex" method="GET">
                        <div class="col-md-1">
                            <input type="submit" class="btn btn-default" role="button" value="Cancel"/>
                        </div>
                        </form>
                    



                
            </div>
    </body>
</html>
