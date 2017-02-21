import Deck from './deck.js';
import Dealer from './dealer.js';


var $ = require("jquery");

export default class Player {



    constructor(deck, fn) {
        this.points = 0;
        this.deck = deck;
        this.fn = fn;
        var self = this;
        $("#container").on('click', '#startGame', function(event) {

            event.preventDefault();
            /* Act on the event */
            $(".btnBox").empty();

            var buttonHit = $('<button>').addClass("btn").text("HIT").attr('id', "hit");
            var buttonStand = $('<button>').addClass("btn").text("STAND").attr('id', "stand");
            $(".btnBox").append($('<div>').addClass("btnBox").append(buttonHit, buttonStand));

            self.deck.draw(2)
                .then((cards) => {
                    console.log(cards)
                    self.cards = cards;
                    self.renderCards(self.cards);
                });

        });

        $("#container").on('click', '#hit', function(event) {
            event.preventDefault();
            /* Act on the event */
            self.deck
                .draw(1)
                .then((cards) => {
                    self.cards = cards;
                    self.renderCards(self.cards);
                });
        });


        $("#container").on('click', '#stand', function(event) {
            event.preventDefault();
            /* Act on the event */

            $(".btnBox").empty();

            var buttonDeal = $('<button>').addClass("btn").text("DEAL").attr('id', "deal");

            $(".btnBox").append('<br>', '<br>', '<br>').append(buttonDeal);


            self.fn(2);

        });

        $("#container").on('click', '#deal', function(event) {
            event.preventDefault();
            /* Act on the event */
            console.log(self)
            self.fn(1);

        });

    }





    renderCards(drawnCards) {

        console.log(drawnCards);

        var self = this;


        drawnCards.cards.forEach(function(element, index) {

            if (drawnCards.cards[index].value == "KING" ||
                drawnCards.cards[index].value == "QUEEN" ||
                drawnCards.cards[index].value == "JACK")
                self.points += 10;
            else if (drawnCards.cards[index].value == "ACE")
                self.points += 1;
            else
                self.points += parseInt(drawnCards.cards[index].value);



        });

        console.log(self.points)

        if (self.points <= 21) {
            drawnCards.cards.forEach(function(element, index) {
                $(".placeHolder")
                    .append($('<img>')
                        .addClass("gridImgPlayer img-responsive")
                        .attr("src", drawnCards.cards[index].image));


            });
        } else {

            setTimeout(function() {
                $(".grid").empty();

                $(".grid").append($('<div>').addClass("title"))
                    .append($('<div>').addClass("logoHolder").html($('<img>').attr("src", "../src/busted.png")))
                    .append('<br>')
                    .append($('<div>').addClass("gameOver").text("PLAYER LOSES"))
                    .append('<br>')
                    .append($('<div>').addClass("logoHolder").html($('<img>').attr("src", "../src/gameOver.png")));

            }, 1000);


        }

    }
}
