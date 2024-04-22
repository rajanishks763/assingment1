<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
*{
padding:0px;
margin: 0px;
box-sizing: border-box;
}
h2{
	margin: 50px 70px;
	
}
	pre input{
		padding: 10px;
		margin-bottom: 15px;
		width: 200px;
		border-radius: 5px;
	}
	pre button{
	padding: 8px 12px;
	border-radius: 5px;
	}
</style>
</head>
<body>
	<h2>Login Page</h2>
	<form action="login" method="post">
		<pre>
			
			<input type="text" name="loginId" placeholder="loginId"/>
			
			<input type="text" name="password" placeholder="password"/>
			<button type="submit" value="save">Submit</button>
		</pre>
		</form>
	${msg}
</body>
</html>