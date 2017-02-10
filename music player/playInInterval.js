//Music Player Class

function MusicPlayer() {

    this.tracks = [];
    this.current = 0;
    this.interval;
};

//Music Player Methods

MusicPlayer.prototype.add = function(track) {
    if (track.hasOwnProperty("title") && track.hasOwnProperty("artist") && track.hasOwnProperty("album"))
        this.tracks.push(track);
    else console.log("Incomplete Info About Track Given")
};

MusicPlayer.prototype.playAll = function(track) {
    console.log("Playing " + track.tracks[track.current].title + " by " + track.tracks[track.current].artist + " from album " + track.tracks[track.current].album);
    ++track.current;
    track.interval = setInterval(track.playAll, 2000, track);
};

MusicPlayer.prototype.stopPlay = function(track) {
    setTimeout(function() {
        console.log("Stopping");
        clearInterval(track.interval);
    }, (track.tracks.length-1) * 2000);
};

// Tracks Class

function TrackInfo(title, artist, album) {

    this.title = title;
    this.artist = artist;
    this.album = album;
};

//Creating instances of MusicPlayer and TrackInfo & addding them to MusicPlayer

var track1 = new MusicPlayer();
var helloTrack = new TrackInfo("Hello", "Adele", "Some");
var byeTrack = new TrackInfo("Bye", "Sting", "Then");
var lastTrack = new TrackInfo("Last", "Me", "After");

track1.add(helloTrack);
track1.add(byeTrack);
track1.add(lastTrack);

// Executing methods

console.log("\nExecuting Playlist\n");

track1.playAll(track1);
track1.stopPlay(track1);
