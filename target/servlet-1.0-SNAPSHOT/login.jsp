<%@ page trimDirectiveWhitespaces="true" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

login success : <% session.getAttribute("id");%><br>
<a href ="/logout">Logout</a><br>
<a href="/foods">FOOD</a><br>
<a href="/cart">CART</a><br>