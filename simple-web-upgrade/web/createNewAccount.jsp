<%-- 
    Document   : createNewAccount
    Created on : Nov 29, 2022, 11:02:33 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>
        <h1>Create New Account Page</h1>
        <form action="main" method="post">
            <label>User ID(*):</label>&emsp;
            <input type="text" name="txtUserID" value="" required>(6-9 charaters)(Ex:SE1405...)<br>
            <label>Last name(*):</label>
            <input type="text" name="txtLastName" value="" required>(2-9 charaters)(Ex:hai,my...)<br>
            <label>Password(*):</label>&#160;
            <input type="password" name="txtPassword" value="" required>(1-9 charaters)<br>
            <label>Confirm pass(*):</label>
            <input type="password" name="txtConfirmPass" value="" required><br>
            <label>Role:</label>
            <select name="cmbRole">
                <option value="AD">Admin(AD)</option>
                <option value="US">User(US)</option>
            </select>
            </br></br></br>
            <input type="submit" name="action" value="Create New Account">
            <input type="reset" value="Reset">
        </form>
        </br>
        <a href="login.jsp">Login Page</a>
        <%
            String lengthID = (String) request.getAttribute("lengthID");
            if (lengthID == null) {
                lengthID = "";
            }
        %>
        <br>
        <h3 style="color: red">
            <%=lengthID%>
        </h3>
        
        <%
            String lengthName = (String) request.getAttribute("lengthName");
            if (lengthName == null) {
                lengthName = "";
            }
        %>
        <br>
        <h3 style="color: red">
            <%=lengthName%>
        </h3>
        
        <%
            String lengthPass = (String) request.getAttribute("lengthPass");
            if (lengthPass == null) {
                lengthPass = "";
            }
        %>
        <br>
        <h3 style="color: red">
            <%=lengthPass%>
        </h3>
        
        <%
            String confirm = (String) request.getAttribute("confirm");
            if (confirm == null) {
                confirm = "";
            }
        %>
        <br>
        <h3 style="color: red">
            <%=confirm%>
        </h3>


        <%
            String duplicated = (String) request.getAttribute("duplicated");
            if (duplicated == null) {
                duplicated = "";
            }
        %>
        <br>
        <h3 style="color: red">
            <%=duplicated%>
        </h3>

    </body>
</html>
