<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="static/css/common.css" rel="stylesheet" type="text/css">
        <link href="static/css/style.css" rel="stylesheet" type="text/css">
        <title>Find us</title>
    </head>
    <body>
        <div class="main-wrapper">
            <%@include file="component/header.jsp"%>  
            <div class="main-body">
                <div class="left px-1">
                    <!--<div class="main-body">-->
                    <h2 class="product-title">Find us</h2>
                    <div class="flex no-collapse"><!--no-collapse overflow: hidden; -->
                        <table class="info-table">
                            <tr class="sub-title">
                                <th class="text-left">Address and contact:</th>
                                <th>Opening hours:</th>
                            </tr>
                            <c:forEach items="${contacts}" var="contact">
                                <tr>
                                    <td>${contact.contact}</td>
                                    <td class="pl-4">${contact.opening}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <img class="map-img" src="static/images/map.png">
                </div>
                <%@include file="component/right-content.jsp"%>
            </div>
            <%@include file="component/footer.jsp"%>
        </div>
    </body>
</html>
