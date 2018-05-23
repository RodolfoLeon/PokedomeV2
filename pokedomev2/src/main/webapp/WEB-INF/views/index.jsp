<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style type="text/css">
        <%@include file="../css/login.css" %>
	</style>
	<title></title>
</head>
<body>
	<div id="wrapper">
		<div class="panel">
			<ul class="panel__menu" id="menu">
			    <li id="signIn"> <a href="#">Login</a></li>
			    <li id="signUp"><a href="#">Sign up</a></li>
			    <hr/>
			</ul>
			<div class="panel__wrap">
				<div class="panel__box active" id="signInBox">
					<form action="/login" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<label for="username">Username:
						<input type="text" name="username">
						</label>
						<label for="password">Password:
						<input type="password" name="password">
						</label>
						<input type="submit" value="Login">
					</form>
				</div>
				<div class="panel__box" id="signUpBox">
					<form:form action="/registration" method="post" modelAttribute="new_user">
						<form:label path="username">Username
						<form:errors path = "username" class="red"/>
						<form:input path = "username"/>
						</form:label>
						<form:label path="password">Password
						<form:errors path = "password" class="red"/>
						<form:password path = "password"/>
						</form:label>
						<form:label path="passwordConfirmation">Confirm Password
						<form:errors path = "passwordConfirmation" class="red"/>
						<form:password path = "passwordConfirmation"/>
						</form:label>
						<input type="submit" value="Register">
					</form:form>
			    </div>
			</div>
		</div>
	</div>
</body>
<script src="js/login.js"></script>
</html>