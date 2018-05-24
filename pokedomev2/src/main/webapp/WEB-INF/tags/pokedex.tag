<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<div id="pokedex">
	<div id="left_pane">
    <img src="" alt="pokemon img">
    <div id="info">
        <p>Name: ${pokemon.name} </p>
        <p>ID: ${pokemon.id}</p>
        <p>Type: ${pokemon.types}</p>
        <p>Height: ${pokemon.height}</p>
        <p>Weight: ${pokemon.weight}</p>
    </div>
    <a href="#" class="add_to_team button"></a>
	</div>
	<div id="pokemon_list">
	    <p>
	        <img class='img img-thumbnail' style='width:50px' src='img/pokemonSprites/${pokemon.id}.png' alt="${pokemon.id}">
	        <a href="/pokemon/get/${pokemon.id}">${pokemon.id}</a>
	    </p>
	</div>
</div>