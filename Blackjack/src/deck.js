import Player from './player.js';
import Dealer from './dealer.js';

export default class Deck {

    constructor(deck_id) {

        this.deck_id = deck_id;
    }



    draw(num) {
        return fetch(`https://deckofcardsapi.com/api/deck/${this.deck_id}/draw/?count=` + num)
            .then(function(res) {
                return res.json();
            })
            .then(function(data) {
                return data;
            });

    }

    deal(num) {

        console.log(this);
        var self = this;

        fetch(`https://deckofcardsapi.com/api/deck/${this.deck_id}/draw/?count=` + num)
            .then(function(res) {
                return res.json();
            })
            .then(function(data) {

                return data;

            }).then(data => self.renderDealerCards(data));

    }

}
