"use strict";

let newStudentForm = document.querySelector("#newStudentForm");
let inpFirstName = document.querySelector("#firstName");
let inpLastName = document.querySelector("#lastName");
let inpAge = document.querySelector("#age");
let inpPhoto = document.querySelector("#photo");





newStudentForm.addEventListener("submit", function(event) {
	
	let firstName = inpFirstName.value;
	let lastName = inpLastName.value;
	let age = inpAge.value;
	let photo = inpPhoto.files[0];
	
	if (photo.lenght === 0) {
		alert("filePhoto.lenght === 0");
	}
	
	createStudent(firstName, lastName, age, photo);
	event.preventDefault();
	location.reload();
}, true);


function createStudent(firstName, lastName, age, photo) {

	let formData = new FormData();
	formData.append("firstName", firstName);
	formData.append("lastName", lastName);
	formData.append("age", age);
	formData.append("photo", photo);

	let xhr = new XMLHttpRequest();
	xhr.open("POST", "/uploadStudent");

	xhr.onload = function() {
		console.log(xhr.responseText);
	}
	xhr.send(formData);
}
