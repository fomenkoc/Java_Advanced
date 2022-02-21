"use strict";

let studentsDiv = document.querySelector("#students");

let xhr = new XMLHttpRequest();
xhr.responseType = "json";
xhr.onreadystatechange = function() {
	if (xhr.readyState == XMLHttpRequest.DONE) {

		let response = xhr.response;

		response.forEach(student => {
			
			studentsDiv.innerHTML += '<div class="student"> <img src="./photos/'
			 + student.id + '" alt="" class="photo"> <br> ' 
			 + student.firstName + ' ' 
			 + student.lastName + ', ' 
			 + student.age + ' </div>';

		});
	}
}
xhr.open("GET", "/getStudents", true);
xhr.send(null);

