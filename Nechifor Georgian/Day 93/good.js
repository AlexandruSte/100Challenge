const arr = ['bag', 'tree', 'number'];

//simple loops are faster tho
	/* not */
// for(let i = 0; i < arr.length; i++) {
// 	console.log(arr[i]);
// }

	/* good */
// for(const e of arr) {
	// console.log(e);
// }

arr[Symbol.iterator] = function() {
	let i = 0;
	let arr = this;
	return {
		next: function() {
			if( i >= arr.length) {
				return {done: true};
			} else {
				const value = arr[i] + " iterator";
				i++;
				return {value, done:false};
			}
		}	
	};};

// arr.forEach(v => console.log(v));

const varr = {horse: 'h', zebra: 'z', unicord: 'u'};

for(const k in varr) {
	console.log(k);
}

for(const v of Object.values(varr))
	console.log(v);



const obj = {
	name: 'Georgian',
	mail: 'nechiforgeorgian@gmail.com',
	address: 'Calea Nationala nr. 7, bl. D, ap. 20',
	age: 21
};

const { name, mail, address, age} = obj;
console.log(`Client ${name} living at ${address} has ${age} yo and can be contacted at ${mail}`);



const v = ['act', 'de', 'rupt', 'hartii', 'de', 'impaturit', 'muntele'];
const arr2 = [...v, 'pentru', 'ca', 'nu', 'merita'];

console.log(arr2);
console.log(v);

const [ , , ...arr1] = v; //delete 2 elements
const [ , , , ...arr3] = v; //delete 3 elements

let x = window.prompt('hai mars');
document.getElementById('title').innerHTML = x;



