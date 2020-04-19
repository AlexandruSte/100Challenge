// var str = 'Ce sa faci "daca asta nu ma vrea"';
// var str1 = 'Ce sa faci daca \nce dracu e asta';
// //window.alert(str1);

// function makeString(noun, adj, verb, adverb) {
// 	let result = "";
// 	result = "The " + adj + " " + noun + " " + verb + " " + adverb;
// 	return result;
// }

// //window.alert(makeString("woman", "beautiful", "sucks it", "godly"));

// var dict = {
// 	FirstName: "Georgian",
// 	Age: 23,
// 	Ocupation: "Student"
// };


// var array = [["Eu", 22], ["El", 21], ["ea", 69]];

// array.pop(); // delete last
// array.push(["Ele", 33]); // add last

// array.shift(); // remove first
// array.unshift(["Noi", 12]); // add first

// // console.log(array);

function even(number) {
	if(number % 2 == 0) {
		console.log("Number " + number + " is even");
		return true;
	} else {
		console.log("Number " + number + " is odd");
		return false
	}
}
var x = false;
function test() {
    while(x == false) {
        number = window.prompt("Number: ");
       x = even(number);
    }
}

var array = [1, 2, 3, 4, 5];
console.log(JSON.stringify(array));
array.push(6);
console.log(JSON.stringify(array));

var map = {
	FirstName: "Georgian",
	Age: 22,
	Town: "Botosani",
	Mail: "nechiforgeorgian@gmail.com"
};

console.log(JSON.stringify(map));
console.log(map);


// var number = window.prompt("Even number: ");
// x = even(number);
// test();

console.log(3 == 3); // T
console.log(3 === '3'); // F
console.log(3 == '3'); // T

console.log(3 != 3);
console.log(3 != '3');
console.log(3 !== '3');





