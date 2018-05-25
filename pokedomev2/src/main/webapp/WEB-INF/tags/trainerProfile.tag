<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="profile">
	<div id="trainer_data" class="container">
		<div id="left_panel" class="container text-center col-sm">
			<h1>Welcome, ${user.username}</h1>
			<p>
				Total Battles:
				<c:out value="${user.battlesWon + user.battlesLost}" />
			</p>
			<p>Battles Won: ${user.battlesWon}</p>
			<p>Battles Lost: ${user.battlesLost}</p>
		</div>
		<div id="right_panel" class="container text-center col-sm">
			<p><form method="POST" action="/profile/newTeam">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<label for="team_name">Create a new Team
						<input type="text" name="team_name"/></label>
						<input type="submit" value="Create"/>
			</form></p>
			<h3>Current Team</h3>
			<c:forEach items="${user.teams}" var="team">
				<div class="row align-items-center">
				<h5>${team.name}</h5>
				<p><form method="POST" action="/profile/deleteTeam">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="hidden" name="team_id" value="<c:out value = "${team.id}"/>"/>
						<input type="submit" value="Remove Team"/>
				</form></p>
					<c:set var="teamID" value="${team.id}"/>
					<c:forEach items="${team.pokemons}" var="pokemon">
						<div class="card mb-3 mr-2" style="width: 10rem; height: 16rem">
							<img class="card-img-top" src="/img/sprites/${pokemon.id}.png"
								style="text-transform: capitalize" alt="${pokemon.name}">
							<div class="card-body">
								<h5 class="card-title" style="text-transform: capitalize">${pokemon.name}</h5>
								<p style="text-transform: capitalize">
								<c:forEach items="${pokemon.types}" var="type">
	                             ${type.name}
	                        	</c:forEach>
								</p>
								<p>
									<form method="POST" action="/profile">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<input type="hidden" name="team_id" value="<c:out value = "${teamID}"/>"/>
										<input type="hidden" name="poke_id" value="${pokemon.id}"/>
										<input type="submit" value="Remove"/>
									</form>
								</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:forEach>
		</div>
	</div>
</div>