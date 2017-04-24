function Restaurant() {

    this.orders = [];
    this.customer = {};
};

function Dish(name, dishPrice, dishIngredients) {

    this.name = name;
    this.dishPrice = dishPrice;
    this.dishIngredients = dishIngredients;
};

function Ingredient(ingredientName, costIngredient) {

    this.ingredientName = ingredientName;
    this.costIngredient = costIngredient;
};

Restaurant.prototype.orderDish = function(dishName, customer) {

    this.orders.push(dishName);
    this.customer = customer;

};

Restaurant.prototype.printOrders = function() {

    for (var i = 0; i < this.orders.length; i++) {
        console.log("Order #" + i + ": " + this.orders[i].name);

    }

};

Restaurant.prototype.printCheck = function() {

    var totalBill = 0;

    for (var i = 0; i < this.orders.length; i++) {
        console.log(this.customer.name);
        console.log("Order #" + i + ": " + this.orders[i].name + " - " + this.orders[i].dishPrice);
        totalBill += this.orders[i].dishPrice;

    }

    console.log('Total Amount' + ":" + totalBill);

};

Restaurant.prototype.totalProfit = function() {

    var totalPrice = 0;
    var totalCost = 0;

    for (var i = 0; i < this.orders.length; i++) {
        totalCost += this.orders[i].cost();
        totalPrice += this.orders[i].dishPrice;
    }
    console.log(totalCost, totalPrice);

    console.log('Total Profit' + ":" + (totalPrice - totalCost));

};

Restaurant.prototype.customerProfit = function(customerName) {

    var totalPrice = 0;
    var totalCost = 0;


    for (var i = 0; i < this.orders.length; i++) {

        if (this.customer.name === customerName.name) {
            totalCost += this.orders[i].cost();
            totalPrice += this.orders[i].dishPrice;
        }
    }
    console.log(totalCost, totalPrice);

    console.log('Total Profit Customer ' + this.customer.name + ":" + (totalPrice - totalCost));

};



Dish.prototype.cost = function() {

    var totalcost = 0;
    var dishCost = 0;
    for (var i = 0; i < this.dishIngredients.length; i++) {
        totalcost += this.dishIngredients[i].costIngredient;
    }

    dishCost = totalcost + 10;

    return dishCost;


};


Dish.prototype.profit = function() {

    var dishCost = this.cost();

    var profit = 0;

    profit = this.dishPrice - dishCost;


    console.log("Profit: " + profit);


};


var pluto = {
    name: 'Pluto',
    id: 1
};
var goofy = {
    name: 'Goofy',
    id: 2
};

var cheese = new Ingredient('Cheese', 5);
var pepperoni = new Ingredient('pepperoni', 12);
var dough = new Ingredient('dough', 2);
var lettuce = new Ingredient('lettuce', 1);
var tomato = new Ingredient('tomato', 4);

var pizza = new Dish('Pizza', 35, [cheese, pepperoni, dough]);
var salad = new Dish('Salad', 40, [lettuce, cheese, tomato]);


var cafeNow = new Restaurant();
cafeNow.orderDish(pizza, goofy);
cafeNow.orderDish(pizza, pluto);
cafeNow.orderDish(salad, pluto);
//cafeNow.orderDish(salad);
pizza.cost();
pizza.profit();
cafeNow.printOrders();
cafeNow.printCheck(goofy);
cafeNow.printCheck(pluto);
cafeNow.totalProfit();
cafeNow.customerProfit(goofy);
cafeNow.customerProfit(pluto);

console.log(cafeNow);
