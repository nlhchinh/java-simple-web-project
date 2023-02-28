<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="chinh.account.AccountDTO"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Search</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            String lastname = String.valueOf(session.getAttribute("userName"));
            if (lastname != null) {
                out.println("<font color='red'>Welcome,"
                        + lastname
                        + "</font>");
            } else {
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    String userName = cookies[1].getValue();
                    out.println("<font color='red'>Welcome,"
                            + userName
                            + "</font>");
                }
            }
        %>
        <a href="main?action=logout">Logout</a>
        <h1>Search Page</h1>
        <form action="main" method="post">
            Search Value <input type="text" name="txtSearchValue" value=""></br>
            <input type="submit" value="search" name="action"><br><br>
        </form>
        <br/>

        <%            String searchValue = request.getParameter("txtSearchValue");
            if (searchValue != null) {
                List<AccountDTO> result = (List<AccountDTO>) request.getAttribute("SEARCHRESULT");
                if (result != null) {
                    out.println("Your search value is " + searchValue);
        %>
        <br><br>
        <table border="1">
            <thead>
                <tr>
                    <th>UserID</th>
                    <th>Lastname</th>
                    <th>Password</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (AccountDTO dto : result) {
                %>
            <form action="main">
                <tr>
                    <td><%= dto.getUserID()%></td>
                <input type="text" name="txtUserID" value="<%= dto.getUserID()%>" hidden/>
                <td><input type="text" name="txtLastName" value="<%=  dto.getLastName()%> "></td>
                <td><input type="text" name="txtPassword" value="<%=  dto.getPassword()%> "></td>
                <td style="text-align: center"><%= dto.getRole()%></td>
                <input type="hidden" name="txtRole" value="<%= dto.getRole()%>"/>
                <td><input type="submit" name="action" value="delete"></td>
                <input type="hidden" name="lastSearchValue" value="<%=searchValue%>">
                <td><input type="submit" name="action" value="update"></td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <style>
        td input[type="checkbox"] {
            float: left;
            margin: 0 auto;
            width: 100%;
        }
    </style>
    <small style="color: green">
        <br>
        Note:<br>
        "Lastname" and "password" length must be less than 10 and more than 1 charater.<br>
    </small>
    <%
    } else {
    %>
    <h2>No record is matched!!! </h2>
    <%
            }
        }
    %>
</body>
</html>
