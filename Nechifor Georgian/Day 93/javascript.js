"use strict";

var collection = {
	1: {
		album: 'Slippery When Wet',
		artist: 'Bon Jovi',
		tracks: [
			'Let it Rock',
			'You Give Love a Bad Name'
		]
	},
	2: {
		album: '1999',
		artist: 'Prince',
		tracks: [
			'1999',
			'Little Red Corvette'
		]
	},
	3: {
		artist: 'Robert Palmer',
		tracks: []
	},
	4: {
		album: 'Eu beau vinul cu borcanul',
		artist: 'Nicu Paleru',
		tracks: [
			'Eu beau vinul cu borcanul',
			'Viata de golan',
			'Dau la cioc ca mortpop'
		]
	},
	5: {
		album: 'Da da test',
		artist: 'Ian'
	}
};


function updateRecord(id, prop, value) {
	if (value === "")
		delete collection[id][prop];
	else if (prop === "tracks") {
		collection[id][prop] = collection[id][prop] || [];
		collection[id][prop].push(value);
	} else {
		collection[id][prop] = value;
	}

	return collection;
}


function printCollection() {
	console.log(JSON.parse(JSON.stringify(collection)));


	colleciton = updateRecord(1, 'artist', 'Lov Jovi');
	collection = updateRecord(1, 'tracks', 'test');
	collection = updateRecord(3, 'tracks', 'test');
	collection = updateRecord(5, 'tracks', 'test');

	console.log(JSON.parse(JSON.stringify(collection)));

}
var concat = (str1, str2) => str1.concat(str2);

console.log(concat([1, 2, 3], [3, 4, 5]));

//map filter reduce


const realNumbersArray = [4, 5.6, -9.8, 3.14, 42, 6, 8.32, -2];

const squareList = (arr) => {
	const squaredInt =
		arr.filter(e => Number.isInteger(e) && e > 0)
		.map(x => x * x);

	return squaredInt;
}

const increment = (() => {
	return function increment(number, value = 1) {
		return number + value;
	}
})();

realNumbersArray.sort();
console.log(squareList(realNumbersArray));

console.log(increment(5, 10));
console.log(increment(5));



const sum = (() => {
	return function sum(...args) { //toate argumentele sunt facute array args
		return args.reduce((a, b) => a + b, 0);
	}
})();

console.log(sum(1, 2, 3, 4));


const arr1 = ['A', 'B', 'C', 'D'];

let arr2;

(function() {
	// arr2 = arr1; // pointer la arr1
	arr2 = [...arr1];  //copiaza continutul 
	arr1[0] = 'XXX';
})();

// console.log(arr2);
// console.log(arr1);



const src = [1, 2, 3, 4, 5, 6];

function removeFirstTwo(list) {
	const [ , , ...arr] = list;
	return arr;
}

// const arr = removeFirstTwo(src);
// console.log(src);
// console.log(arr);


class Person {
	constructor(name, mail, age) {
		this.name = name;
		this.mail = mail;
		this.age = age;
	}
}

var person1 = new Person("Georgian", "nechiforgeorgian@gmail.com", 22);
console.log(person1);
console.log(person1.name);




