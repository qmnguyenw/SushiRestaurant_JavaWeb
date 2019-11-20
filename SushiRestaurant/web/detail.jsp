<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="static/css/common.css" rel="stylesheet" type="text/css">
        <link href="static/css/style.css" rel="stylesheet" type="text/css">
        <title>Detail Page</title>
    </head>
    <body>
        <div class="main-wrapper">

            <%@include file="component/header.jsp"%>  
            <div class="main-body">
                <div class="left px-1">
                    <c:if test="${notFound}">
                        <h2 class="product-title">No article displayed</h2>
                    </c:if>
                    <c:if test="${!notFound}">
                        <p class="product-title">${displayArticle.title}</p>
                        <p class="product-content mt-2">
                            <img class="product-img-detail" src="${displayArticle.image}">
                            <div class="product-content"> ${displayArticle.content}</div>
                        </p>
                    </c:if>
                </div>
                <%@include file="component/right-content.jsp"%>    
            </div>
            <%@include file="component/footer.jsp"%>
        </div>
    </body>
</html>
