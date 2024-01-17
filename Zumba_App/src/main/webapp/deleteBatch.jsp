<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Delete Batch</h2>

<form action="BatchController" method="post">

<input type="hidden" name="operation" value="delete"><br/>

<label>BatchId</label>
<input type="number" name="batchid"/><br/> 
 
 <input type="submit" value="Delete Batch"/>
<input type="reset" value="reset"/> <br/> 

<a href="index.html">Back</a>
</form>
</body>
</html>