<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h3>Login Page</h3>
        <form action="main" method="post">
            User Name:<input type="text" name="txtLastName" value=""/><br>
            Password:<input type="password" name="txtPassword" value=""/></br><br>
            <input type="submit" value="login" name="action"/>
            <input type="reset" value="Reset"/>
        </form>
        <br>
        <a href="shopping.jsp">Go to Shopping</a></br>
        <a href="createNewAccount.jsp">Create New Account</a>
    </body>
    <%
            String success = (String) request.getAttribute("success");
            if (success == null) {
                success = "";
            }
        %>
        <br>
        <h3 style="color: green">
            <%=success%>
        </h3>
</html>
