<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body class="loginpage">

	<div class="login">
	
		<div class="login-logo" style="text-align: center;">
	        <img style="height: 84px;" src="/NewsPageMVC/resources/img/vnua.png" >
	    </div>

		<form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
			<p>
				<label for="user_login">Username or Email Address</label>
				<form:input path="username" type="text" name="log" id="user_login" class="input" value="" size="20" autocapitalize="off"/>
							
			
			</p>
			<div class="user-pass-wrap">
				<label for="user_pass">Password</label>
				<div class="wp-pwd">
					<form:input path="password" type="password" name="pwd" id="user_pass" class="input password-input" value="" size="20"/>
				</div>
			</div>
			
			<button type="submit" class="btn btn-primary">Đăng nhập</button>
			
		</form:form>
		<br>
		<p id="backtoblog"><a href="/NewsPageMVC">&larr; Trở lại trang chủ</a></p>
		<p style="font-style:italic; font-size:1.3vw; color:red;">${message}</p>
	</div>
</body>
</html>
<%-- 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form:form id="loginForm" modelAttribute="login" action="loginProcess"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="username">Username: </form:label></td>
				<td><form:input path="username" name="username" id="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><form:button id="login" name="login">Login</form:button></td>
			</tr>

			<tr></tr>
			<tr>
				<td></td>
				<td><a href="home.jsp">Home</a></td>
			</tr>
		</table>
	</form:form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>

</body>
</html>
 --%>