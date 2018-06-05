<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        

    </head>
    <body>
        <div class="container">
            <h1> Vending Machine Application </h1>
            <hr/>

            <!-- LEFT SIDE COLUMN ====================================================-->
            <div class="col-md-9">


                <sf:form class="form-horizontal" id="form-input" role="form" method="POST" action="submitForm" modelAttribute="inputFormObject" > 

                    <ul id="items" style="list-style-type: none; padding: 0px; margin: 0px">
                        <!-- dynamically add list items with divs as bordered boxes -->
                        <c:forEach var="currentItem" items="${itemList}">
                            <li>
                                <a style="text-decoration: none; color: black" href="selectItem?itemId=${currentItem.itemId}&total=${inputFormObject.total}">

                                    <div class="col-md-3" style="border: 2px solid black; margin: 2%">
                                        <p> <c:out value="${currentItem.itemId}"/>
                                        </p>
                                        <p style="display: block; text-align: center">
                                            <c:out value="${currentItem.name}"/>
                                        </p>
                                        <p>
                                            $<c:out value="${currentItem.price}"/>
                                        </p>
                                        <br>
                                        <p>
                                            Quantity: <c:out value="${currentItem.amountInStock}"/>
                                        </p>
                                    </div> 
                                </a> 

                            </li>
                        </c:forEach>
                    </ul>
                </div>


                <!-- RIGHT SIDE COLUMN ===================== -->
                <div class="col-md-3">

                    <!--       MONEY IN Section ========================================= -->

                    <div class="row">
                        <h3 class="text-center">Total $ In</h3>

                        <div class="row form-group">
                            <div class="col-md-offset-3 col-md-6">
                                <sf:input type="text" class="form-control" id="money-display" path="total" readonly="true" />                          
                                <sf:errors path="total" cssclass="error"></sf:errors>
                                </div>
                            </div>   

                            <div class="row form-group">
                                <div class="col-md-5">
                                    <input type="submit" role="button" class="btn btn-default" id="add-dollar" name="addDollar" value="Add Dollar"/>
                                </div>


                                <div class="col-md-offset-2 col-md-5">
                                    <input type="submit" role="button" class="btn btn-default" id="add-quarter" name="addQuarter" value="Add Quarter"/>
                                </div>

                            </div>
                            <div class="row form-group">
                                <div class="col-md-5">
                                    <input type="submit" role="button" class="btn btn-default" id="add-dime" name="addDime" value="Add Dime"/>
                                </div>


                                <div class="col-md-offset-2 col-md-5">
                                    <input type="submit" role="button" class="btn btn-default " id="add-nickel" name="addNickel" value="Add Nickel"/>
                                </div>
                            </div>

                            <!-- MESSAGES AND PURCHASE FORM  PART OF SPRING FORM-=============================-->

                            <div class="row">
                                <h3 class="text-center">Messages</h3>

                                <div class="row form-group">
                                    <div class="col-md-12">
                                    <sf:input type="text" class="form-control " path="message" />
                                    <sf:errors path ="message" cssclass="error"></sf:errors>
                                    </div>

                                </div>
                                <div class="row form-group">
                                    <label for="item-selected" class="control-label col-md-2">Item: </label>
                                    <div class="col-md-10">

                                    <sf:input type="text" class="form-control" value="${item.itemId}" path="itemSelectedIdString"/>
                                    <sf:errors path="itemSelectedIdString" cssclass="error"></sf:errors>

                                    </div>
                                </div>

                                <div class="row form-group">
                                    <input type="submit" class="btn btn-default col-md-offset-2 col-md-8" role="button" value="Make Purchase" name="makePurchase"/>

                                </div>


                            </div>
                            <hr/>




                            <!-- CHANGE FORM ======================================= -->

                            <div class="row">
                                <h3 class="text-center"> Change</h3>


                                <div class="row form-group">
                                    <div class="col-md-offset-2 col-md-8">
                                    <sf:textarea class="form-control" id="change-display" rows="4" path="change"></sf:textarea>
                                    </div>
                                </div>

                                <div class="row form-group">
                                    <input type="submit" class="btn btn-default col-md-offset-3 col-md-6" role="button" value="Return Change" name="returnChange" id="change-return"/>



                                </div>

                        </sf:form>

                    </div

                </div>













                <div>
                    <p><a href="${pageContext.request.contextPath}/index.jsp"> Return to landing page </a>
                </div>


            </div>



            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

