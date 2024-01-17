
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Batch Details</h2>
<table border="1" class="table table-striped">
<tr>
	<th>Batch Id</th>
	<th>Type Of Batch</th>
	<th>Time</th>
	<th style="text-align: center;" colspan="2">Action</th>
</tr>

<core:forEach items="${sessionScope.batchInfo}" var="batch">
	<tr>
		<td><core:out value="${batch.getBatchid()}"></core:out> </td>
		<td><core:out value="${batch.getTypeofbatch()}"></core:out> </td>
		<td><core:out value="${batch.getTime()}"></core:out> </td>
		<td><a href="updateBatch.jsp">Update</a></td>
		<td><a href="deleteBatch.jsp">Delete</a></td>
	</tr>
</core:forEach>
</table>
<a href="index.html">Back</a>
</body>
</html>