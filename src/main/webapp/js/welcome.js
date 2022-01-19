"use strict";

let user = null;

/*$.get("user", function(data) {
	if (data !== '') {
		user = data;
	}
}).done(function(){
	console.log(user);
	
	$("#qqq").innerHTML = user.firstName;
	let test = $("#qqq");
	console.log(test);
	console.log(user.firstName); 
});*/


$.get("user", function(data) {
	if (data !== '') {
		user = data;

	}
}).done(function() {
	document.getElementById("user-name").innerHTML = user.firstName + " " + user.lastName;
	let test = document.getElementById("user-name");
	console.log(test); 
});


