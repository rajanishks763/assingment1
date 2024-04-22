<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>
	
	<th><a href="/auth/add">Add Customer</a></th> 
	<th>Customer Details</th>
	<pre>
	<table cellspacing="10px">
	<thead>
	<tr style="border-bottom:1px solid black;">
	<th>First Name</th>
	<th>Last Name</th>
	<th>Address</th>
	<th>City</th>
	<th>State</th>
	<th>Email</th>
	<th>Phone</th>
	<th>Action</th>
	</tr>
	</thead>

	<tbody>
	<c:forEach var="contact" items="${contact}" >
	<tr>
	<td>${contact.firstName }</td>
	<td>${contact.lastName }</td>
	<td>${contact.address }</td>
	<td>${contact.city }</td>
	<td>${contact.state }</td>
	<td>${contact.email }</td>
	<td>${contact.phone }</td>
	<td><a href="/auth/delete/${contact.id}/delete" &>&#9940</a>  <a href="/auth/edit/${contact.id}">&#9998</a></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	</pre>
	${msg}
</body>
</html>