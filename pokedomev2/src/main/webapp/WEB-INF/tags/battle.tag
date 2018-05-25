<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="battle" class="row">
	<div class ="col-sm text-center">
        <h3>${user.username}</h3>
        <div class="team" id="user_side">
            <c:forEach items="${user.teams.get(0).pokemons}" var="pokemon" varStatus="loop">
                <div class="row  text-center">
                <c:if test ="${ loop.index == 0 }">
                <img class="rounded mx-auto d-block active_mine" src="img/sprites/${pokemon.id}.png" alt="pokemon" id="${pokemon.id}">
                </c:if>
                <c:if test ="${ loop.index != 0 }">
                <img class="rounded mx-auto d-block" src="img/sprites/${pokemon.id}.png" alt="pokemon" id="${pokemon.id}">
                </c:if>
                </div>
            </c:forEach>
        </div>
    </div>
    <div id="battle_dome"  class ="col-sm">
        <div id="duel">
        	<img src="img/versus2.png" class = "d-block mt-2 mb-5" alt="vs" width="30%">
        	<button id="fight" class = "btn btn-danger mt-4 mb-4 d-block">Battle!</button>
            <textarea id="battle_log" class = "mx-auto" cols="30" rows="6"></textarea>
        </div>
    </div>
    <div class ="col-sm text-center">
        <h3>${oponent.username}</h3>
        <div class="team" id="oponent_side"  >
            <c:forEach items="${oponent.teams.get(0).pokemons}" var="pokemon" varStatus="loop">
            	<div class="row">
            	<c:if test ="${ loop.index == 0 }">
                <img class="rounded mx-auto d-block active_other" src="img/sprites/${pokemon.id}.png" alt="pokemon" id="${pokemon.id}">
                </c:if>
                <c:if test ="${ loop.index != 0 }">
                <img class="rounded mx-auto d-block" src="img/sprites/${pokemon.id}.png" alt="pokemon" id="${pokemon.id}">
                </c:if>
                </div>
            </c:forEach>
        </div>
    </div>
</div>