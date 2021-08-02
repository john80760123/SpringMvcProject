<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login System</title>
</head>
<body> 
<h3>Login System</h3>
<form action="loginAccountCheck.controller" method="post">
   <table>
       <tr>
          <td>UserName:</td>
          <td><input type="text" name="userName"/></td>
          <td>${errors.userName}</td>
       </tr>
       <tr>
          <td>Password:</td>
          <td><input type="password" name="userPwd"/></td>
          <td>${errors.userPwd}</td>
       </tr>
       <tr>
          <td><input type="submit" value="Login"/></td>
          <td>${errors.msg}</td>
       </tr>
   </table>
</form>
</body>
</html>