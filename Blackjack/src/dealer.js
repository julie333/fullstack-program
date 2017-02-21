import Deck from './deck.js';
import Player from './player.js';

var $ = require("jquery");

export default class Dealer {

    constructor(deck_id) {

        this.deck_id = deck_id;
        this.dealerPoints = 0;

    }

    gameOver() {

        $(".grid").empty();


        console.log('dealer points ', this.dealerPoints)
        console.log('player points ', this.player.points)


        if (this.dealerPoints === this.player.points)
            var winner = 'IT\'S A TIE';
        else {
            if (this.dealerPoints > this.player.points)
                var winner = 'DEALER WINS';
            else
                var winner = 'PLAYER WINS';
        }

        $(".grid").append($('<div>').addClass("title"))
            .append($('<div>').addClass("logoHolder").html($('<img>').attr("src", "../src/card.png")))
            .append('<br>')
            .append($('<div>').addClass("gameOver").text(winner))
            .append($('<div>').addClass("logoHolder").html($('<img>').attr("src", "../src/gameOver.png")))

    }


    renderDealerCards(dealerCards) {

        var self = this;
        console.log(dealerCards);


        dealerCards.cards.forEach(function(element, index) {

            $(".placeHolder")
                .append($('<img>')
                    .addClass("gridImgDealer img-responsive")
                    .attr("src", dealerCards.cards[index].image));

            let cardValue = 0;

            if (dealerCards.cards[index].value == "KING" ||
                dealerCards.cards[index].value == "QUEEN" ||
                dealerCards.cards[index].value == "JACK")
                cardValue += 10;
            else if (dealerCards.cards[index].value == "ACE")
                cardValue += 1;
            else
                cardValue += parseInt(dealerCards.cards[index].value);

            if (self.dealerPoints + cardValue < 17) {
                self.dealerPoints += cardValue;
                console.log('dealerPoints', self.dealerPoints)


            } else if (self.dealerPoints + cardValue > 21) {
                self.dealerPoints += cardValue;
           setTimeout(function() {
                  $(".grid").empty();
                $(".grid").append($('<div>').addClass("title"))
                    .append($('<div>').addClass("logoHolder").html($('<img>').attr("src", "../src/busted.png")))
                    .append('<br>')
                    .append($('<div>').addClass("gameOver").text("DEALER LOSES"))
                    .append('<br>')
                    .append($('<div>').addClass("logoHolder").html($('<img>').attr("src", "../src/gameOver.png")));
                }, 1000);


                

            } else if (self.dealerPoints + cardValue >= 17 && self.dealerPoints + cardValue <= 21) {
                self.dealerPoints += cardValue;
                console.log('I am here')

                setTimeout(function() {
                    self.gameOver();
                }, 1000);



            }



        });


    }




}
