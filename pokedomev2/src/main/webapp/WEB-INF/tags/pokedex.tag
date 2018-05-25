<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="pokedex" class="container row">
	<div id="left_pane" class="col-sm">
    <img class src="/img/sprites/${currentPokemon.id}.png" alt="pokemon img">
    <div id="info">
        <p style="text-transform: capitalize">Name: ${currentPokemon.name} </p>
        <p>ID: ${currentPokemon.id}</p>
        <p style="text-transform: capitalize">Types: 
        <c:forEach items="${currentPokemon.types}" var="type">
        ${type.name} 
        </c:forEach>
        </p>
        <p>Height: ${currentPokemon.pk_height} m</p>
        <p>Weight: ${currentPokemon.pk_weight} kg</p>
        <p>Description: ${currentPokemon.description}</p>
        
    </div>
        <div class="container border">
		<form method="POST" action="/pokedex/${currentPokemon.id}">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<table>
			<tr>
				<td>
					<label for="team_id">Team</label>
				</td>
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
	            <td>
	            	<input type="submit" value="Add Pokemon to Team"/>
	            </td>		
			</tr>		
		</table>
		</form>
         		<p class="small">
         		If no Teams are displayed, means that your teams are full.
         		</p>
        </div>
    <a href="#" class="add_to_team button"></a>
	</div>
	<div id="pokemon_list" class="container col-sm" style="overflow-y:scroll; height:500px">
		<c:forEach items="${allPokemons}" var="pokemon">
	    <p style="text-transform: capitalize">
	        <img class='img img-thumbnail' style='width:75px' src='/img/sprites/${pokemon.id}.png' alt="${pokemon.id}">
	        <a href="/pokedex/${pokemon.id}">${pokemon.name}</a>
	    </p>
	    </c:forEach>
	</div>
</div>