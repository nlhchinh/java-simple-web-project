<%-- 
    Document   : viewCart.jsp
    Created on : Nov 29, 2022, 10:21:05 PM
    Author     : Admin
--%>

<%@page import="chinh.shopping.Tea"%>
<%@page import="chinh.shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <%
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart == null) {
        %>
        <h1>You cart is empty!!!</h1>
        <a href="shopping.jsp">Continue to shopping</a>
        <%
        } else {
        %>
        <h1>Your shopping cart</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Sub Total</th>
                    <th>Update</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    int total = 0;
                    for (Tea tea : cart.getCart().values()) {
                        total += tea.getQuantity() * tea.getPrice();
                %>
            <form action="main">
                <tr>
                    <td><%= count++%></td>
                    <td><%= tea.getId()%></td>
                    <td><%= tea.getName()%></td>
                    <td>
                        <input type="number" name="quantity" min="1" value="<%= tea.getQuantity()%>">
                    </td>
                    <td><%= tea.getPrice()%> 000 VND</td>
                    <td><%= tea.getQuantity() * tea.getPrice()%> 000 VND</td>
                    <td>
                        <input type="submit" name="action" value="updateCart">
                        <input type="hidden" name="id" value="<%=tea.getId()%>">
                    </td>
                    <td>
                        <input type="submit" name="action" value="removeCart">
                        <input type="hidden" name="id" value="<%=tea.getId()%>">
                    </td>
                </tr>
            </form>
            <%
                }
            %>

        </tbody>
    </table>
    <h1>Total: <%=total%> 000 VND</h1>
    <small style="color: green">
        Note: <br>
        You can update or remove item from cart.<br>
        Update (quantity must bigger than 0 and  must be an integer).<br><br>
    </small>
    <a href="shopping.jsp">Continue to shopping</a>

    <%
        }
    %>
</body>
</html>
