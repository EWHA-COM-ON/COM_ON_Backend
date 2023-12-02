<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
					  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<center>
<h1>로그인</h1>
<hr>
<form action="login.do" method="post">
	<label for="id">Username:</label>
    <input type="text" id="id" name="id" required><br>
	<label for="pwd">Password:</label>
    <input type="password" id="pwd" name="pwd" required><br>
    
    <button type="submit">Login</button>
</form>
<hr>
</center>
</body>
</html>