<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Paticipant Details</h2>

 <form action="ParticipantController" method="post">
 <input type="hidden" name="operation" value="view"><br/>
 <input type="submit" value="View Paticipant Details">
 </form>

<table border="1" class="table table-striped" >
<tr>
	<th>Participant ID</th>
	<th>participant Name</th>
	<th>Age</th>
	<th>Phone number</th>
	<th>Batch ID</th>
	<th style="text-align: center;" colspan="2">Action</th>
</tr>

<core:forEach items="${sessionScope.participantinfo}" var="participant">
	<tr>
		<td><core:out value="${participant.getParticipantid()}"></core:out> </td>
		<td><core:out value="${participant.getPname()}"></core:out> </td>
		<td><core:out value="${participant.getAge()}"></core:out> </td>
		<td><core:out value="${participant.getPhonenumber()}"></core:out> </td>
		<td><core:out value="${participant.getBatchid()}"></core:out> </td>
		<td><a href="updateBatch.jsp">Update</a></td>
		<td><a href="deleteBatch.jsp">Delete</a></td>
	</tr>
</core:forEach>
</table>

<a href="index.html">Back</a>

</body>
</html>