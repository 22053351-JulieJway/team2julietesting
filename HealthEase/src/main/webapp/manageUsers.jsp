<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Overview of appointments</title>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">


</head>
<body>


<div class="row">
<div class="container">
<h3 class="text-center">List of Appointments</h3>
<hr>
<div class="container text-left">
<!-- Add new user button redirects to the register.jsp page -->
<a href="<%=request.getContextPath()%>/newAppointment.jsp" class="btn
btn-success">Add New Appointments</a>
</div>
<br>
<!-- Create a table to list out all current users information -->
<table class="table">
<thead>
<tr>
<th>NRIC</th>
<th>Name</th>
<th>Health Institution</th>
<th>Doctor Name</th>
<th>Date of Appointment</th>
<th>Time of Appointment</th>
<th>Email</th>
<th>Actions</th>
</tr>

</thead>
<!-- Pass in the list of users receive via the Servlet’s response
to a loop -->
<tbody>
<c:forEach var="user" items="${listUsers}">
<!-- For each user in the database, display their
information accordingly -->
<tr>
<td>
<c:out value="${user.nric}" />
</td>
<td>
<c:out value="${user.name}" />
</td>
<td>
<c:out value="${user.health_institution}" />
</td>
<td>
<c:out value="${user.doctor_name}" />
</td>
<td>
<c:out value="${user.date_of_appointment}" />
</td>
<td>
<c:out value="${user.time_of_appointment}" />
</td>
<td>
<c:out value="${user.email}" />
</td>
<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
<td>
<a href="edit?name=<c:out
value='${user.nric}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="delete?name=<c:out
value='${user.nric}' />">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>




</body>
</html>