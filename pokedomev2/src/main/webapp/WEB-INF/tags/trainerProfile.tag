<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<div id="profile">
	<nav class="nav justify-content-end navbar-light bg-light">
                <a class="nav-link active" href="/pokedex/">Pokedex</a>
                <a class="nav-link active" href="/trainer/{{request.session.user_id}}/edit">Edit Profile</a>
                <a class="nav-link" href="#">Battle Dome</a>
                <a class="nav-link" href="/logout">Log Out</a>
        </nav>
        <div id="trainer_data">
            <div id="left_pane">
                <h1>Hello, ${user.username}</h1>
                <img src="" alt="Trainer image">
                <p>Total Battles: <c:out value = "${user.battlesWon + user.battlesLost}"/></p>
                <p>Battles Won: ${user.battlesWon}</p>
                <p>Battles Lost: ${user.battlesLost}</p>
            </div>
            <div id="right_pane">
                <h4>Current Team</h4>
                <c:forEach items="${user.team}" var="pokemon">
                    <div class="card" style="width: 10rem; height: 14rem">
                        <img class="card-img-top" src="" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">${pokemon.name}</h5>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
	</ul>
</div>