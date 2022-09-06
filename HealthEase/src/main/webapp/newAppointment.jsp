<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> HealthEase Add Appointment Form</h1>
<form action ="AddAppointmentServlet" method = "post">
    <br>NRIC: <input type = "text" name = "nric">
    <br>Name: <input type = "text" name = "userName">
    <br>Health institution: <select name = "health_institution">
        <option>Woodbridge clinic</option>
        <option>Brinelle clinic</option>
        <option>Bright Day clinic</option>
        <option>Woodbridge hospital</option>
        <option>Bright Day hospital</option>
        <option>Julies hospital</option>
        <option>Js hospital</option>
        </select>
        <br>Doctor Name: <input type = "text" name = "doctor_name">
    <br>Date of Appointment: <input type = "date" name = "date_of_appointment">
    <br>Time of Appointment: <input type = "time" name = "time_of_appointment">
    <br>Email: <input type = "text" name = "email">
  
        <br><input type = "submit" value = "Call Servlet" />
</form>


</body>
</html>