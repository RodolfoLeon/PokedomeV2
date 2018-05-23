<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style type="text/css">
		<%@include file="../css/general.css" %>
	</style>
	<script
	  src="https://code.jquery.com/jquery-3.3.1.min.js"
	  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	  crossorigin="anonymous"></script>
	<script src="js/logout.js"></script>
	<script src="js/pokedome.js"></script>
	<title>Pokedome</title>
</head>
<body>
	<div id="wrapper">
		<form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <a href="#" class="logout">Logout</a>
    	</form>
		<div id="navigation">
			<mytags:navbar/>
		</div>
		<div id="content">
			<mytags:trainerProfile/>
			<mytags:pokedex/>
			<mytags:poketeams/>
			<mytags:pokebarn/>
		</div>
	</div>
</body>
</html>