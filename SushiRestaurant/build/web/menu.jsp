<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="static/css/common.css" rel="stylesheet" type="text/css">
        <link href="static/css/style.css" rel="stylesheet" type="text/css">
        <title>Menu</title>
    </head>
    <body>
        <div class="main-wrapper">
            <%@include file="component/header.jsp"%>  
            <div class="main-body">
                <div class="left px-1">
                    <%--exception handle message--%>
                    <c:if test="${message!=null}">
                        <h2 class="product-title">${message}</h2>
                    </c:if>
                    <%--if no exception--%>
                    <c:if test="${message==null}">
                        <h2 class="product-title">Menu and Price list</h2>
                        <%-- all of article --%>
                        <c:forEach items="${listMenu}" var="menu">
                            <div class="flex no-collapse">
                                <div class="pb-1 mb-2">
                                    <div>
                                        <p class="menu-head pa-05">
                                            Menu ${menu.id}
                                            <span class="right-float">Price</span>
                                        </p>
                                        <p class="pa-05">
                                            ${menu.name}
                                            <span class="right-float">${menu.formatPrice()}</span>
                                        </p>
                                    </div>
                                    <p class="mt-2">
                                        ${menu.content}
                                    </p>
                                    <p class="pt-2 dot-b"></p>
                                </div>
                            </div>
                        </c:forEach>

                        <center>
                            <form action="menu">
                                <c:if test="${currentPage>1}">
                                    <span class="next-pre-icon">
                                        <a class="a-reset" href="menu?currentPage=${currentPage-1}"><</a>
                                    </span>
                                </c:if>
                                <input class="numberbox" type="number" autocomplete="off"
                                       name="currentPage" value="${currentPage}"
                                       min="1" max="${totalPage}" required>/${totalPage}
                                <c:if test="${currentPage<totalPage}">
                                    <span class="next-pre-icon">
                                        <a class="a-reset" href="menu?currentPage=${currentPage+1}">></a>
                                    </span>
                                </c:if>
                            </form>
                        </center>
                    </c:if>
                </div>
                <%@include file="component/right-content.jsp"%>
            </div>
            <%@include file="component/footer.jsp"%>
        </div>
    </body>
</html>
