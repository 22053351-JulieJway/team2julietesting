<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">





</head>
<body>
<nav class="navbar navbar-expand-md navbar-light">
<div>
<a class="navbar-brand"> Appointment Management Application </a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/UserServlet/dashboard"
class="nav-link">Back to Dashboard</a></li>
</ul>
</nav>


<div class="container col-md-6">
<div class="card">
<div class="card-body">
<c:if test="${users != null}">
<form action="update" method="post">
</c:if>
<c:if test="${users == null}">
<form action="insert" method="post">
</c:if>
<caption>
<h2>
<c:if test="${users != null}">
Edit User
</c:if>
<c:if test="${users == null}">
Add New User
</c:if>
</h2>
</caption>
<c:if test="${users != null}">
<input type="hidden" name="oriNric" value="<c:out
value='${users.nric}' />" />
</c:if>

<fieldset class="form-group">
<label>NRIC</label> <input type="text" value="<c:out
value='${users.nric}' />" class="form-control" name="nric" required="required">
</fieldset>

<fieldset class="form-group">
<label>Name</label> <input type="text" value="<c:out
value='${users.name}' />" class="form-control" name="name" required="required">
</fieldset>



<fieldset class="form-group">
<label>Health Institution</label> <input type="text" value="<c:out
value='${users.health_institution}' />" class="form-control" name="health_institution">
</fieldset>

<fieldset class="form-group">
<label>Doctor Name</label> <input type="text" value="<c:out
value='${users.doctor_name}' />" class="form-control" name="doctor_name">
</fieldset>


<fieldset class="form-group">
<label>Date of Appointment</label> <input type="text" value="<c:out
value='${users.date_of_appointment}' />" class="form-control" name="date_of_appointment">
</fieldset>


<fieldset class="form-group">
<label>Time of Appointment</label> <input type="text" value="<c:out
value='${users.time_of_appointment}' />" class="form-control" name="time_of_appointment">
</fieldset>





<fieldset class="form-group">
<label> Email</label> <input type="text" value="<c:out
value='${users.email}' />" class="form-control" name="email">
</fieldset>


<button type="submit" class="btn btn-success">Save</button>
</form>
</div>
</div>
</div>



</body>
</html>