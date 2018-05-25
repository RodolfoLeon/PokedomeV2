$(document).ready (function () {
	
	var myName = "";
	var myHP = 100;
	var myWins = 0;
	var oponentHP = 100;
	var oponentWins = 0;
	
	$.get ("/pokemon/get/1", function (pokemon) {
		console.log ("POKENAME: "+pokemon.name);
		myName = pokemon.name;
	});

	console.log ("POKENAME: "+myName);

})