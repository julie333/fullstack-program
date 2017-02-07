/* Javascript Excersises - Julie */


console.log("\n1. Reverse\n");

var s1 = "ReverseThisString";

console.log("Reversed String is " + reverse(s1));

function reverse(string) {

    return string.split("").reverse().join("");
}



console.log("\n2. Factorial\n");

var num1 = 10;
console.log("Factorial of 10 is " + factorial(num1));

function factorial(n) {

    if (n === 1) return 1;

    return n * factorial(n - 1);
}



console.log("\n3. Longest Word\n");

var sentence = "Which looks like the longest word ?"

console.log("The longest word is " + longest_word(sentence))

function longest_word(sentence) {

    var sentenceArray = sentence.split(" ");
    var longestword = "";

    for (var i = 0; i < sentenceArray.length; i++) {

        if (sentenceArray[i].length > longestword.length)
            longestword = sentenceArray[i];
    }

    return longestword;
}



console.log("\n4. Sum Nums\n");

var num2 = 15;
console.log("The sum of 0 to " + num2 + " is " + sum_nums(num2));

function sum_nums(num) {

    var sum = 0;
    var i = 0;

    while (i <= num) {
        sum += i;
        i++;
    }

    return sum;
}



console.log("\n5. Time Conversion\n");

var minutes = 79;

console.log('Hours: ' + time_conversion(minutes))

function time_conversion(minutes) {

    var mins = minutes % 60;
    var hours = ((minutes - mins) / 60);

    if (minutes < 60) return minutes + " minutes";

    return hours + ":" + mins;
}



console.log("\n6. Count Vowels\n");

var s2 = "This sentence has so many vowels";

console.log('Number of vowels : ' + count_vowels(s2));

function count_vowels(string) {

    return string.match(/[aeiou]/gi).length;
}



console.log("\n7. Palindrome\n");

var s3 = "malayalam";
var s4 = "menu";

console.log(s3 + palindrome(s3));
console.log(s4 + palindrome(s4));


function palindrome(string) {

    for (var i = 0; i < string.length; i++) {

        if (string.charAt(i) === string.charAt(string.length - i - 1)) {
            continue;
        } else return " IS Not a Palindrome";
    }

    return " Is a Palindrome";
}



console.log("\n8. Most Letters\n");

var s5 = "zabbbz";
var s6 = "afz";
var s7 = "abbfabz";

nearby_az(s5);
nearby_az(s6);
nearby_az(s7);


function nearby_az(string) {

    var pos_a = [];
    var pos_z = [];

    for (var i = 0; i < string.length; i++) {

        if (string[i] === "a") pos_a.push(i);
        if (string[i] === "z") pos_z.push(i);
    }

    for (var i = 0; i < pos_a.length; i++)
        for (var j = 0; j < pos_z.length; j++) {

            if (pos_z[j] - pos_a[i] > 0 && pos_z[j] - pos_a[i] <= 3) {
                return console.log(string + ":" + "true");
            }
        }

    return console.log(string + ":" + "false");
}



console.log("\n9. Two Sum\n");

var arr1 = [-2, 4, 0, -4, 2];
var arr2 = [2, 4, 5, 0, 6];

two_sum(arr1);
two_sum(arr2)

function two_sum(nums) {

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




console.log("\n10. Is Power of Two\n");

var num3 = 72;
var num4 = 64;


console.log(num3 + is_power_of_two(num3));
console.log(num4 + is_power_of_two(num4));

function is_power_of_two(num) {

    var i = 1;

    if (num % 2 === 0) {

        while (i < (num / 2)) {

            if (Math.pow(2, i) === num)
                return " Is a power of 2";

            i++;
        }
    }

    return " Is Not a power of 2";
}
