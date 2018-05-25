<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="pokedex" class="container row">
	<div id="left_pane" class="col-sm">
    <img src="/img/sprites/${pokemon.id}.png" alt="pokemon img">
    <div id="info">
        <p>Name: ${pokemon.name} </p>
        <p>ID: ${pokemon.id}</p>
        <p>Types: 
        <c:forEach items="${pokemon.types}" var="type">
        ${type.name} 
        </c:forEach>
        </p>
        <p>Height: ${pokemon.pk_height}</p>
        <p>Weight: ${pokemon.pk_weight}</p>
        <p>Description: ${pokemon.description}</p>
        
    </div>
    <a href="#" class="add_to_team button"></a>
	</div>
	<div id="pokemon_list" class="col-sm">
		<c:forEach items="${allPokemons}" var="pokemon">
	    <p>
	        <img class='img img-thumbnail' style='width:50px' src='/img/sprites/${pokemon.id}.png' alt="${pokemon.id}">
	        <a href="/pokedex/${pokemon.id}">${pokemon.name}</a>
	    </p>
	    </c:forEach>
	</div>
</div>