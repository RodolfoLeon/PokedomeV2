<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="battle">
	<div id="user_side">
        <h3>${user.username}</h3>
        <div id="team">
            <c:forEach items="${user.teams.get(0).pokemons}" var="pokemon">
                <img src="img/sprites/${pokemon.id}.png" alt="poke">
            </c:forEach>
        </div>
    </div>
    <div id="battle_dome">
        <div id="duel">
            <img src="" alt="my pokemon">
            <textarea id="battle_log" cols="30" rows="6"></textarea>
            <img src="" alt="enemy pokemon">
        </div>
    </div>
    <div id="oponent_side">
        <h3>${oponent.username}</h3>
        <div id="team">
            <c:forEach items="${oponent.teams.get(0).pokemons}" var="pokemon">
                <img src="img/sprites/${pokemon.id}.png" alt="poke">
            </c:forEach>
        </div>
    </div>
</div>