console.log("\nisString\n");

function isString(myString) {

    if (typeof(myString) === "string") {
        return "true";
    } else {
        return false;
    }
}

console.log(isString("var"));
console.log(isString(56));


console.log("\nisArray\n");

function isArray(myArray) {


    if (typeof(myArray) === "object") {
        return "true";
    } else {
        return false;
    }
}

console.log(isArray("var"));
console.log(isArray(56));
console.log(isArray([2, "a", {}, true]));

console.log("\n Are all of the same type\n");

function areSameType(myArray2) {

    for (var i = 0; i < myArray2.length; i++) {
        for (var j = i; j < myArray2.length; j++) {
            if (typeof(myArray2[i]) === typeof(myArray2[j])) {
                continue;
            } else {
                console.log("not of same type");
                return false;
            }
        }
    }
    (
        console.log(typeof(myArray2[0])));
    return true;
}


console.log(areSameType([2, 3, 4]));
console.log(areSameType([2, "a", {}, true]));
console.log(areSameType(["a", "b", "4"]));


console.log("\n Sort the array \n");

function longest(s1, s2) {

    var stringArray = (s1 + s2).split("").sort();
    var finalArray = [];


    for (var i = 0; i < stringArray.length; i++) {

        if (!(finalArray.includes(stringArray[i]))) {
            finalArray.push(stringArray[i]);
        }

    }

    console.log(finalArray);
}

longest("julie", "eddy");

console.log("\n Convert number to reversed array of digits\n");

function convert(num) {
    var convertArray = parseInt(num.toString().split("").sort().reverse().join(""));
    console.log(convertArray);
}

convert(654728364825374732);
convert(47390);



console.log("\n Array repetition\n");

var countArrRep = ['kerouac', 'fante', 'fante', 'buk', 'hemingway', 'hornby', 'kerouac', 'buk', 'fante'];
var i = 0;
var count = 0;

function arrayRep(countArrRep) {

var list={};

countArrRep.forEach( function(element, index) {



		
});

console.log(list);


}

arrayRep(countArrRep);

console.log("\n Cat and mouse\n");
//contains('text to find');

function isCaught(mystring3) {

    if (mystring3.includes('C') && mystring3.includes('m')) {

        var n = Math.abs(mystring3.indexOf("C") - mystring3.indexOf("m"));
        if (n <= 3) console.log(true);
        else return console.log(false);
    } else return console.log(false);

}

isCaught('C.....m');
isCaught('C..m');
isCaught('..C..m');
isCaught('......');
isCaught('..f..m');




console.log("\n Exponentiation\n");

function exp(num1, num2) {

    if (num2 === 1) return num1;
    return num1 * exp(num1, num2 - 1);

    //console.log(Math.pow(num1,num2));

}

console.log(exp(2, 3)); //8


console.log("\n Split the Bill\n");

var group = {
    Amy: 20,
    Bill: 15,
    Chris: 10
}

// Object.prop = key of an object
// Object[prop] = value of the object

function splitTheBill(groupBill) {

    var totalBill = 0;
    var individualBill = 0;

    for (var prop in groupBill) {

        totalBill += groupBill[prop];

    }

    individualBill += totalBill / 3;

    for (var prop in groupBill) {

        groupBill[prop] = groupBill[prop] - individualBill;

    }

    console.log(groupBill);
}

splitTheBill(group);

//Fibonacci Series

var sum = 0;
var series = [];
function fibonacci(num) {
	
    if (num > 0) {
        if (num == 1){
        	series.push(num);
            return 1;
        }
        else {
            sum = fibonacci(num - 1) + fibonacci(num - 2);
             series.push(num);
            return sum;
        }
    } else {
        return 0;
    }

   
}
 console.log(series);
console.log(fibonacci(7));

console.log("\nZero Sum\n");

var arr1 = [-2, 4, 0, -4, 2];
var arr2 = [2, 4, 5, 0, 6];

zero_sum(arr1);
zero_sum(arr2)

function zero_sum(nums) {

    var result = [];

    for (var i = 0; i < nums.length; i++)
        for (var j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] === 0) {
                result.push([i, j]);
            }
        }

    if (result.length > 0) {
        console.log("Array: " + nums + " Positions are: ");
        console.log(result);
    } else
        console.log("Array: " + nums + " Positions are nil");
}


console.log("\n Factorial\n");

var num1 = 10;
console.log("Factorial of 10 is " + factorial(num1));

function factorial(n) {

    if (n === 1) return 1;

    return n * factorial(n - 1);
}
