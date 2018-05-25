$(document).ready (function () {
	
	$.get ("/pokemon/get/1", function (pokemon) {
		console.log ("Pokemon: "+pokemon);
		console.log ("Pokemon: "+pokemon.name);
	})
	
	var myHP = pokemon.hp
	var myWins = pokemon.;
	var oponentHP = 100;
	var oponentWins = 0;
	
	$('#fight').on ('click', function () {
//		$.get ("/fight", function (htmldata) {
//			console.log ("Data: "+htmldata);
//			myHP -= 20;
//			console.log ("pokehealth: "+myHP);
//			$('#battle_log').append ("\n"+myHP);
//		})
		
	})
	
	
	
	
})
