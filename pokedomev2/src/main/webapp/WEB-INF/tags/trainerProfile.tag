<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="profile">
	<nav class="nav justify-content-end navbar-light bg-light">
                <a class="nav-link active" href="/pokedex/">Pokedex</a>
                <a class="nav-link active" href="/trainer/{{request.session.user_id}}/edit">Edit Profile</a>
                <a class="nav-link" href="#">Battle Dome</a>
                <a class="nav-link" href="/logout">Log Out</a>
        </nav>
        <div id="trainer_data" class="container">
            <div id="left_panel" class="container text-center col-sm">
                <h1>Hello, ${user.username}</h1>
                <img src="" alt="Trainer image">
                <p>Total Battles: <c:out value = "${user.battlesWon + user.battlesLost}"/></p>
                <p>Battles Won: ${user.battlesWon}</p>
                <p>Battles Lost: ${user.battlesLost}</p>
            </div>
            <div id="right_panel" class="container text-center col-sm">
                <h3>Current Team</h3>
                <c:forEach items="${user.teams}" var="team">
                	<div class="row">
                	<c:forEach items="${team.pokemons}" var="pokemon">
	                    <div class="card mb-2 mr-2" style="width: 10rem; height: 14rem">
						<img class="card-img-top" src="img/sprites/${pokemon.id}.png" alt="Card image cap">
	                        <div class="card-body">
	                            <h5 class="card-title" style="text-transform: capitalize">${pokemon.name}</h5>
	                            <p style="text-transform: capitalize">
	                             <c:forEach items="${pokemon.types}" var="type">
	                             ${type.name}
	                        	</c:forEach>
	                        	 </p>
	                        </div>
	                    </div>
                	</c:forEach>
                	</div>
                </c:forEach>
            </div>
        </div>
</div>