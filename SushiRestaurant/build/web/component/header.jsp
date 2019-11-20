<%-- 
    Document   : header
    Created on : Jul 14, 2019, 4:52:47 PM
    Author     : Hi?p V?
--%>
<div>
    <div class="header">
        <div class="big-title">The Sushi Restaurant</div>
        <div class="sub-title white">Welcome to this website</div>
    </div>
    <ul class="menu">
        <li class="sub-menu">
        <c:if test="${home != null}"><a class="menu-link font-bold" href="home">Home</a></c:if>
        <c:if test="${home == null}"><a class="menu-link" href="home">Home</a></c:if>
        </li>
        <li class="sub-menu">
        <c:if test="${menu != null}"><a class="menu-link font-bold" href="menu">Menu and Price list</a></c:if>
        <c:if test="${menu == null}"><a class="menu-link" href="menu">Menu and Price list</a></c:if>
        </li>
        <li class="sub-menu">
        <c:if test="${contact != null}"><a class="menu-link font-bold" href="contact">Find us</a></c:if>
        <c:if test="${contact == null}"><a class="menu-link" href="contact">Find us</a></c:if>
        </li>
    </ul>
</div>