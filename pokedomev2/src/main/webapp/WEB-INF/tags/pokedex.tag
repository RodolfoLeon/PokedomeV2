<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="pokedex" class="container row">
	<div id="left_pane" class="col-sm">
    <img src="/img/sprites/${currentPokemon.id}.png" alt="pokemon img">
    <div id="info">
        <p>Name: ${currentPokemon.name} </p>
        <p>ID: ${currentPokemon.id}</p>
        <p>Types: 
        <c:forEach items="${currentPokemon.types}" var="type">
        ${type.name} 
        </c:forEach>
        </p>
        <p>Height: ${currentPokemon.pk_height}</p>
        <p>Weight: ${currentPokemon.pk_weight}</p>
        <p>Description: ${currentPokemon.description}</p>
        
    </div>
        <div class="container border">
		<form method="POST" action="/pokedex/${currentPokemon.id}">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<table>
			<tr>
				<td><label for="team_id">Team</label></td>
				<td>
				<select name="team_id">
					<option value=0>Select a Team</option>
					<c:forEach items="${user.teams}" var="team">
						<c:if test="${ team.pokemons.size() < 3 }">
	            		<option value="${team.id}">${team.name}</option>
	            		</c:if>
	            	</c:forEach>
	            </select>
	            </td>		
	            <td colspan="2"><input type="submit" value="Add Pokemon to Team"/></td>		
			</tr>		
		</table>
		</form>
         		<p class="small">
         		If no Teams are displayed, means that your teams are full.
         		</p>
        </div>
    <a href="#" class="add_to_team button"></a>
	</div>
	<div id="pokemon_list" class="container col-sm" style="width: 45%;overflow-y:scroll; height:500px">
		<c:forEach items="${allPokemons}" var="pokemon">
	    <p>
	        <img class='img img-thumbnail' style='width:50px' src='/img/sprites/${pokemon.id}.png' alt="${pokemon.id}">
	        <a href="/pokedex/${pokemon.id}">${pokemon.name}</a>
	    </p>
	    </c:forEach>
	</div>
</div>