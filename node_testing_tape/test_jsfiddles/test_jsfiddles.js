var test = require("tape");

var tapSpec = require('tap-spec');

test.createStream()
    .pipe(tapSpec())
    .pipe(process.stdout);

var DataType = require('data-type')


var exercises = require('./jsfiddles.js');

test("Test all js Fiddles", function(t) {

    t.true(true, "should work");
    t.end();


   t.test('isAnagram function : when passed an Anagram', function(t) {
        t.true(exercises.isAnagram('hello','elloh'), 'True');
        t.end();
    });

     t.test('isAnagram function : when not passed an Anagram', function(t) {
        t.false(exercises.isAnagram('hello','eoh'), 'False');
        t.end();
    });


        t.test('boxVolume function', function(t) {
        t.equal(exercises.boxVolume(1,2,3), 0.006, "Correct Volume");
        t.end();
    });


        t.test('boxVolume function', function(t) {
        t.equal(exercises.boxVolume(8,6,9) , 0.432, "Correct Volume");
        t.end();
    });

     t.test('boxVolume function', function(t) {
        t.notEqual(exercises.boxVolume(1,2,3), 0.06, "Wrong Volume");
        t.end();
    });


    t.test('isString function : when passed a string', function(t) {
        t.true(exercises.isString('hello'), 'should return true');
        t.end();
    });

    t.test('isString function : when passed an array', function(t) {
        t.false(exercises.isString([1, 2]), 'should return false');
        t.end();
    });

    t.test("isArray function : when string is passed", function(t) {
        t.false(exercises.isArray("2"));
        t.end()
    });

    t.test("isArray function : when array is passed", function(t) {
        t.ok(exercises.isArray([2, "a", {}, true]));
        t.end();
    });

    t.test("isArray function : DataType when array is passed", function(t) {
        t.ok(DataType.isArray([2]));
        t.notOk(DataType.isArray("String"));
        t.end();
    });

    t.test("areSameType : when same types are passed", function(t) {
        t.true(exercises.areSameType([2, 3, 4]));
        t.end();
    });

    t.test("areSameType : when different types are passed", function(t) {
        t.false(exercises.areSameType([2, "a", {}, true]));
        t.end();
    });


    t.test("longest : find longest of two strings", function(t) {
        t.deepEqual(exercises.longest("da", "abc"), ['a', 'b', 'c', 'd'], "da/abc");
        t.end();
    });
    t.test("longest : find longest of two strings", function(t) {

        t.notDeepEqual(exercises.longest("daf", "abc"), ['a', 'b', 'c', 'd'], "daf / abc ");
        t.end();
    });


    t.test('Reverse Numbers', function(t) {

        t.equal(exercises.convert(1234), 4321, "Reversed Correctly");
        t.notEqual(exercises.convert(1234), 3241, "Reversed Wrongly");
        t.end();

    });


    t.test('isCaught : Cat & Mouse', function(t) {

        t.ok(exercises.isCaught("C..m"), "Caught");
        t.ok(exercises.isCaught("..C..m"), "Caught");
        t.notOk(exercises.isCaught("..f..m"), "Not Caught");
        t.notOk(exercises.isCaught("....."), "Not Caught");
        t.end();

    });


    t.test('Exponentiation', function(t) {

        t.equal(exercises.exp(2, 2), 4, "Correct Exponentiation");
        t.notEqual(exercises.exp(2, 3), 16, "Wrong Exponentiation");
        t.end();

    });

    t.test('splitTheBill', function(t) {

        t.deepEqual(exercises.splitTheBill({ Amy: 20, Bill: 15, Chris: 10 }), { Amy: 5, Bill: 0, Chris: -5 }, "Correct splitTheBill");
        t.notDeepEqual(exercises.splitTheBill({ Amy: 20, Bill: 15, Chris: 15 }), { Amy: 5, Bill: 0, Chris: -5 }, "Wrong splitTheBill");

        t.end();

    });


    t.test('fibonacci', function(t) {

        t.deepEqual(exercises.fibonacci(7), 13, "Correct fibonacci");
        t.notDeepEqual(exercises.fibonacci(3), 4, "Wrong fibonacci");
        t.notDeepEqual(exercises.fibonacci(0), 1, "Wrong fibonacci");

        t.end();

    });

    t.test('factorial', function(t) {

        t.equal(exercises.factorial(5), 120, "Correct Factorial");
        t.equal(exercises.factorial(1), 1, "Correct Factorial");
        t.notEqual(exercises.factorial(0), 0, "Correct Factorial");


    });

});
