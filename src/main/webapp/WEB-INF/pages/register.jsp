<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<div>
	<h2 style="text-align: center;">User Registration</h2>
		<div>
			<c:if test="${not empty error}">
				<strong style="color: red;"><c:out value="${error}"/></strong>
			</c:if>
		</div>
		<div>
			<c:if test="${param.success ne null}">
				<strong style="color: green;">User registration successful</strong>
			</c:if>
		</div>
		<form method="post" action="register">
			<table>
				<tbody>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name" id="name"
							value="${user.name}" /></td>
					</tr>
					<tr>
						<td>Age</td>
						<td><input type="text" name="age" id="age"
							value="${user.age}" /></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="email" name="email" id="email"
							value="${user.email}" /></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address" id="address"
							value="${user.address}" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><button type="submit">Register</button></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>