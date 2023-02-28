<%-- 
    Document   : shopping
    Created on : Nov 29, 2022, 9:37:05 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
    </head>
    <body>
        <h1>Welcome to our tea shop</h1>
        <form action="main">
            Choose your tea:
            <select name="cmbTea">
                <option value="T01-Ice Lemon Tea-10">Ice Lemon Tea</option>
                <option value="T02-Traditional Milk Tea-25">Traditional Milk Tea</option>
                <option value="T03-Caramel Milk Tea-35">Caramel Milk Tea</option>
                <option value="T04-Chocolate Milk Tea-30">Chocolate Milk Tea</option>
                <option value="T05-Black Sugar Milk Tea-35">Black Sugar Milk Tea</option>
            </select>
            <input type="number" name="quantity" value="1" min="1"/>
            <input type="submit" name="action" value="addToCart"/>
            <input type="submit" name="action" value="viewCart"></br></br>
            <a href="login.jsp">Login Page</a>
        </form>

        <%
            String message = (String) request.getAttribute("message");
            if (message == null) {
                message = "";
            }
        %>
        <br>
        <h3 style="color: green">
            <%=message%>
        </h3>
    </body>
</html>
