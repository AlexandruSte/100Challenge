document.getElementById("submit").addEventListener("click", function(event) {
	event.preventDefault();
	let firstName = document.getElementById("firstName").value;
	let lastName = document.getElementById("lastName").value;
	let address = document.getElementById("address").value;
	let mail = document.getElementById("mail").value;
	let number = document.getElementById("phone").value;

	if(firstName != "" && lastName != "" && address != "" && mail != "" && number != "") {
		const object = {firstName, lastName, address, mail, number};
		console.log(object);
		document.getElementById("reset").reset();
	} else {
		window.alert("Complete all the fields");
	}
});

// function myFunction(event) {
// 	"use strict";
// 	event.preventDefault();

// 	let firstName = document.getElementById("firstName").value;
// 	let lastName = document.getElementById("lastName").value;
// 	let address = document.getElementById("address").value;
// 	let mail = document.getElementById("mail").value;
// 	let number = document.getElementById("phone").value;

	

// 	if(firstName != "" && lastName != "" && address != "" && mail != "" && number != "") {
// 		const object = {firstName, lastName, address, mail, number};
// 		console.log(object);


// 		document.getElementById("reset").reset();

// 		return object;
// 	} else {
// 		window.alert("Complete all the fields");
// 	}
// };


