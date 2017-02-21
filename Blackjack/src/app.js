import '../src/main.css';

var $ = require("jquery");
import Deck from './deck.js';
import Player from './player.js';
import Dealer from './dealer.js';

console.log('hello Blackjack');

$(function() {

    fetchDeck();

    function renderLayout() {

        var grid = $('<div>').addClass("grid");
        var buttonStart = $('<button>').addClass("btn").text("START GAME").attr('id', "startGame");

        grid.append($('<div>').addClass("title"))
            .append($('<div>').addClass("logoHolder").html($('<img>').attr("src", "../src/blackjack_logo.png")))
            .append('<br>', '<br>')
            .append($('<div>').addClass("placeHolder"))
            .append('<br>', '<br>', '<br>')
            .append($('<div>').addClass("btnBox").append(buttonStart))
            .append('<br>');

        $("#container").append(grid);
    }

    renderLayout();

    function fetchDeck() {
        fetch('https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1')
            .then(function(res) {
                return res.json();
            })
            .then(function(data) {

                var newDeck = new Deck(data.deck_id);
                var dealer = new Dealer(data.deck_id);
                var player = new Player(newDeck, newDeck.deal.bind(dealer));
                dealer.player = player;
                //var game = new Game(newDeck, dealer, player);
                console.log(data.deck_id);

            });
    }




});
