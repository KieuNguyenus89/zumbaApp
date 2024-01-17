<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Update Batch</h2>
<form action="BatchController" method="post">
<input type="hidden" name="operation" value="update"><br/>
<label>BatchId</label>
<input type="number" name="batchid"/><br/>
 <label>Typeofbatch</label>
 <input type="radio" name="typeofbatch"  value="morning">Morning
<input type="radio" name="typeofbatch" value="evening">Evening<br/>
 <label>Time</label>
 <select name="time">
 	<option value="7am">7am</option>
 	<option value="8am">8am</option>
 	<option value="9am">9am</option>
 	<option value="7pm">7pm</option>
 	<option value="8am">8pm</option>
 	<option value="9am">9pm</option>
 </select><br/>
 
 <input type="submit" value="Update Batch"/>
<input type="reset" value="reset"/> <br/> <br/> 

<a href="index.html">Back</a>
</form>

</body>
</html>