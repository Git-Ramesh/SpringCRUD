<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div>
		<h1 style="text-align: center;">Login</h1>
		<div>
			<c:if test="${param.error ne null}">
				<strong style="color: red;">Invalid Username or Password</strong>
			</c:if>
		</div>
		<form action="login" method="post">
			<table>
				<tbody>
					<tr>
						<td>Username</td>
						<td><input type="text" name="username" value="${username}" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" name="password" value="${password}" /></td>
					</tr>
					<tr>
						<td colspan="2"><button type="submit" name="submit">Login</button></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>