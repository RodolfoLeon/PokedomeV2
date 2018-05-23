$(document).ready (function () {
    $('.profile').on ('click', function () {
    	//get requests to the server to get the info needed for the dynamic data in the tag
//    	$.get ("/profile", function (htmldata) {
//            console.log ("Data: "+htmldata);
    	
    	
    	//makes profile visible and turns everything else off
        $('#profile').show();
        $('#pokedex').hide();
        $('#poketeams').hide();
        $('#pokebarn').hide();
    });
    $('.pokedex').on ('click', function () {
        $('#profile').hide();
        $('#pokedex').show();
        $('#poketeams').hide();
        $('#pokebarn').hide();
    });
    $('.poketeams').on ('click', function () {
        $('#profile').hide();
        $('#pokedex').hide();
        $('#poketeams').show();
        $('#pokebarn').hide();
    });
    $('.pokebarn').on ('click', function () {
        $('#profile').hide();
        $('#pokedex').hide();
        $('#poketeams').hide();
        $('#pokebarn').show();
    });
});