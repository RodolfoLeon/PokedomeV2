<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<ul>
	<li><a href="/profile" class="profile">Trainer Profile</a></li>
	<li><a href="/pokedex" class="pokedex">Pokedex</a></li>
	<li><a href="/battle" class="battle">Pokemon battle</a></li>
	<li><form action="/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="Logout!">
    	</form></li>
</ul>