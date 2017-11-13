<%@ page import="DAO.DAOSearch" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%DAOSearch.getData(request.getParameter("name"), request.getParameter("surname"));%>
<table border="2" cellpadding="4">
    <tr>
        <td>Name</td>
        <td>Surname</td>
        <td>Phone Number</td>
        <td>E-mail</td>
    </tr>
    <tr>
        <td><%=request.getParameter("name")%></td>
        <td><%=request.getParameter("surname")%></td>
        <td><%=DAOSearch.getPhone()%></td>
        <td><%=DAOSearch.getEmail()%></td>
    </tr>
</table>
</body>
</html>
