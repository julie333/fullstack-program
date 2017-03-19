import '../src/main.css';

var $ = require("jquery");

console.log('hello music player');

$(function() {


    $("#container").on('click', '#search', function(event) {
        event.preventDefault();

        var searchItem = $("#boxSearch").val().replace(" ", "+");
        console.log("Searching ", searchItem);
        userSearch(searchItem)
            .then((tracks) => {
                console.log(tracks)
                renderTracks(tracks);
            });
    });

    $("#container").on('click', '.btnImage', function(event) {
        event.preventDefault();
        console.log(event.currentTarget.parentElement.id)
        var trackImage = event.currentTarget.parentElement.id;
        renderAudio(event, event.currentTarget.parentElement.id);
    });

    $("#container").on('keyup input', '#boxSearch', function(event) {
        event.preventDefault();

        $(".gridTracksWrapper").empty();
        $(".gridTracks").remove();
        var searchItem = $("#boxSearch").val().replace(" ", "+");
        console.log("Searching ", searchItem);
        userSearch(searchItem)
            .then((tracks) => {
                renderTracks(tracks);
            });
    });

    function renderAudio(event, trackImage) {

        $(".selectedTrack").remove();
        $(".trackPic").remove();

        var selectedTrack = $('<div>').addClass("selectedTrack")
        var audioTrack = $('<audio></audio>').attr({
            src: event.currentTarget.id,
            controls: true
        });

        selectedTrack.append('<br>').append(audioTrack);
        $(".placeHolder").append($('<div>').addClass("trackPic").html($('<img>').attr("src", trackImage))).append(selectedTrack);

        // $(event.target).parent().append(selectedTrack);

    }

    function renderTracks(trackList) {

        var gridTracksWrapper = $('<div>').addClass("gridTracksWrapper").text('Tracks Found: ');
        var count = 1;
        trackList.tracks.items.forEach(function(element, index) {

            var buttonStart = $('<img>').attr("src", "../src/play.png").addClass("btnImage").attr('id', trackList.tracks.items[index].preview_url);
            var trackImage = trackList.tracks.items[index].album.images[1].url;
            var track = $('<p>' + (count++) + ".  " + trackList.tracks.items[index].name + '</p>')
                .attr('id', trackImage)
                .append(buttonStart);

            var gridTracks = $('<div>').addClass("gridTracks").append(track);
            gridTracksWrapper.append(gridTracks);
            $(".grid").append(gridTracksWrapper);

        });
    }

    function userSearch(searchItem) {
        return fetch("https://api.spotify.com/v1/search?q=" + searchItem + "&type=track")
            .then(function(res) {
                return res.json();
            })
            .then(function(data) {

                return data;
            });
    }

    function renderLayout() {

        var grid = $('<div>').addClass("grid");
        var buttonSearch = $('<button>').addClass("btn").text("SEARCH").attr('id', "search");
        var boxSearch = $('<input type="text">').attr('placeholder', "Enter Track Name").attr('id', "boxSearch");

        grid.append($('<div>').addClass("title").text("Spotify Music Player"))

        .append($('<div>').addClass("placeHolder"))
            .append('<br>')
            .append($('<div>').append(boxSearch))
            .append($('<div>').addClass("btnBox").append(buttonSearch))
            .append('<br>');

        $("#container").append(grid);
    }

    renderLayout();

});

// .append($('<div>').addClass("logoHolder").html($('<img>').addClass("logo").attr("src", "../src/logo.jpg")))
