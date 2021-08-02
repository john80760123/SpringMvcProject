<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>profiles</title>
</head>
<body>
<h3>profiles</h3>
<form action ="profiles2.controller" method="post">
<p>
  Name   :<input type="text" name="userName"/><br>
  Address:<input type="text" name="userAddress"/><br>
  Phone  :<input type="text" name="userPhone"/><br>
</p>
<input type="submit" value="Send"> 
</form>
</body>
</html>