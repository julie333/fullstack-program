module.exports = {};


//-----------------------------------------------

console.log("\nisAnagram\n");

module.exports.isAnagram = function isAnagram(myString1, myString2) {

    if (myString1.length === myString2.length) {

        myString1.split("").forEach(function(element, index) {

            if (!myString2.includes(element))
                return false;
        });
        return true;
    } else return false;
}


//-----------------------------------------------

console.log("\n Box Volume\n");
module.exports.boxVolume = function boxVolume(num1,num2,num3) {
    var boxVolume = (num1*num2*num3)/1000;
    return boxVolume;
}


//-----------------------------------------------

console.log("\n Rectangle Intersect\n");
module.exports.intersect = function intersect(ptA,ptB) {

    intersect([[1, 1], [4, 3]], [[2, 2], [6, 7]]); // => [2, 2], [4, 3]

var intersectXL = false;
var intersectYL = false;
var intersectXR = false;
var intersectYR = false;
   
if(ptC[0] >= ptA[0] && ptC[0] <= ptB[0])
    intersectXL = true;

if(ptC[1] >= ptA[1] && ptC[1] <= ptB[1])
    intersectYL = true;

if(ptC[0] >= ptA[0] && ptC[0] <= ptB[0])
    intersectXR = true;

if(ptC[1] >= ptA[1] && ptC[1] <= ptB[1])
    intersectYR = true;

if(intersectXL && intersectYL)
    ptE.push(ptC);

}


//-----------------------------------------------

console.log("\nisString\n");

module.exports.isString = function isString(myString) {

        if (typeof(myString) === "string") {
            return "true";
        } else {
            return false;
        }
    }
    //-----------------------------------------------

console.log("\nisArray\n");

module.exports.isArray = function isArray(myArray) {


    if (typeof(myArray) === "object") {
        return "true";
    } else {
        return false;
    }
}

//-----------------------------------------------


console.log("\n Are all of the same type\n");
module.exports.areSameType = function areSameType(myArray2) {

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

//-----------------------------------------------

console.log("\n Longest \n");
module.exports.longest = function longest(s1, s2) {

    var stringArray = (s1 + s2).split("").sort();
    var finalArray = [];


    for (var i = 0; i < stringArray.length; i++) {

        if (!(finalArray.includes(stringArray[i]))) {
            finalArray.push(stringArray[i]);
        }

    }

    return finalArray;
}

//-----------------------------------------------

console.log("\n Convert number to reversed array of digits\n");
module.exports.convert = function convert(num) {
    var convertArray = parseInt(num.toString().split("").sort().reverse().join(""));
    return convertArray;
}

//-----------------------------------------------



console.log("\n Array repetition\n");

var countArrRep = ['kerouac', 'fante', 'fante', 'buk', 'hemingway', 'hornby', 'kerouac', 'buk', 'fante'];
var i = 0;
var count = 0;

module.exports.arrayRep = function arrayRep(countArrRep) {

    var list = {};

    countArrRep.forEach(function(element, index) {

    });

    console.log(list);
}

//-----------------------------------------------

console.log("\n Cat and mouse\n");
module.exports.isCaught = function isCaught(mystring3) {

    if (mystring3.includes('C') && mystring3.includes('m')) {

        var n = Math.abs(mystring3.indexOf("C") - mystring3.indexOf("m"));
        if (n <= 3) return true;
        else return false;
    } else return false;

}

//-----------------------------------------------

console.log("\n Exponentiation\n");
module.exports.exp = function exp(num1, num2) {

    if (num2 === 1) return num1;
    return num1 * exp(num1, num2 - 1);

}

//-----------------------------------------------

console.log("\n Split the Bill\n");

module.exports.splitTheBill = function splitTheBill(groupBill) {

    var totalBill = 0;
    var individualBill = 0;

    for (var prop in groupBill) {

        totalBill += groupBill[prop];

    }

    individualBill += totalBill / 3;

    for (var prop in groupBill) {

        groupBill[prop] = groupBill[prop] - individualBill;

    }

    return groupBill;
}

//-----------------------------------------------

console.log("\n Fibonacci\n");

var sum = 0;
var series = [];

module.exports.fibonacci = function fibonacci(num) {

    if (num > 0) {
        if (num == 1) {
            series.push(num);
            return 1;
        } else {
            sum = fibonacci(num - 1) + fibonacci(num - 2);
            series.push(num);
            return sum;
        }
    } else {
        return 0;
    }

    return series;

}

//-----------------------------------------------

console.log("\nZero Sum\n");
module.exports.zero_sum = function zero_sum(nums) {

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

//-----------------------------------------------

console.log("\n Factorial\n");

module.exports.factorial = function factorial(n) {

    if (n === 1 || n === 0) return 1;

    return n * module.exports.factorial(n - 1);
}
