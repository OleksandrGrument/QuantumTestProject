<%@ page import="test.quantum.domain.Employee" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>


<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="format-detection" content="address=no"/>

    <meta name="description" content=""/>
    <meta name="keywords" content=""/>

    <title>Employee List</title>

    <%@ include file="styles.jsp" %>

</head>
<body>

<%List<Employee> employees = (List<Employee>) request.getAttribute("employees");%>

<table class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>Name Surname</th>
        <th>City</th>
        <th>Salary</th>
        <th>Position</th>
    </tr>
    </thead>
    <tbody>
    <%

        for (int i = 0 ; i < employees.size(); i++){
            Employee employee = employees.get(i);
    %>
        <tr>
            <th scope="row"><%out.print(i+1);%></th>
            <td><%out.print(employee.getNameSurname());%></td>
            <td><%out.print(employee.getCity());%></td>
            <td><%out.print(employee.getSalary() + " $");%></td>
            <td><%out.print(employee.getPosition());%></td>
        </tr>
    <%}%>
    </tbody>
</table>

<!-- #End Wrapper -->

<%@ include file="javascript.jsp" %>


</body>
</html>

