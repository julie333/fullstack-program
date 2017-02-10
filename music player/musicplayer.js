/* Music Player OOP - Julie */

//Music Player Class

function MusicPlayer() {

    this.tracks = [];
    this.current = 0;

};

//Music Player Methods

MusicPlayer.prototype.add = function(track) {
    if (track.hasOwnProperty("title") && track.hasOwnProperty("artist") && track.hasOwnProperty("album"))
        this.tracks.push(track);
    else console.log("Incomplete Info About Track Given")

};

MusicPlayer.prototype.play = function() {
    console.log("Playing " + this.tracks[this.current].title + " by " + this.tracks[this.current].artist + " from album " + this.tracks[this.current].album);
};

MusicPlayer.prototype.next = function() {
    if (this.current === this.tracks.length - 1)
        this.current = -1;

    ++this.current;
    console.log("Playing " + this.tracks[this.current].title + " by " + this.tracks[this.current].artist + " from album " + this.tracks[this.current].album);
};

MusicPlayer.prototype.prev = function() {
    if (this.current === 0)
        this.current = this.tracks.length;

    --this.current;
    console.log("Playing " + this.tracks[this.current].title + " by " + this.tracks[this.current].artist + " from album " + this.tracks[this.current].album);
};

// Select a specific Track directly

MusicPlayer.prototype.selectSpecificTrack = function(track) {

    console.log("\nSelect the Track To Play:\n");
    for (var i = 0; i < track.tracks.length; i++) {
        console.log(i + 1 + ":" + track.tracks[i].title);
    }

    var r1 = require('readline');
    var choice = r1.createInterface(process.stdin, process.stdout);
    choice.question("Enter Track Number to play track ! Any other Key to Exit : ", function(trackNumber) {
        track.current = trackNumber - 1;
        try {
            track.play();
            track.selectSpecificTrack(track);
        } catch (e) {
            console.log("Exiting Player..");
            choice.close();
        }
    });
};

// Get Info of all Tracks

MusicPlayer.prototype.getInfoAllTracks = function() {

    console.log("\nTracks Info:\n");
    for (var i = 0; i < this.tracks.length; i++)
        console.log("Track Title: " + this.tracks[i].title + " Artist: " + this.tracks[i].artist + " Album: " + this.tracks[i].album);
};


// Tracks Class

function TrackInfo(title, artist, album) {

    this.title = title;
    this.artist = artist;
    this.album = album;
};

//TrackInfo Class Methods

TrackInfo.prototype.playTrack = function() {
    console.log("Playing Track " + this.title + " by " + this.artist + " from album " + this.album);
};


//Creating instances of MusicPlayer and TrackInfo & addding them to MusicPlayer

var track1 = new MusicPlayer();
var helloTrack = new TrackInfo("Hello", "Adele", "Some");
var byeTrack = new TrackInfo("Bye", "Sting", "Then");
var lastTrack = new TrackInfo("Last", "Me", "After");

track1.add(helloTrack);
track1.add(byeTrack);
track1.add(lastTrack);
track1.add("Sing Sing");


// Executing methods

console.log("\nExecuting Playlist\n");
track1.play();
track1.prev();
track1.prev();
track1.next();
track1.next();
helloTrack.playTrack();
byeTrack.playTrack();

console.log("\nExecuting Track Details\n");
track1.getInfoAllTracks();

console.log("\nExecuting Select Specific Track\n");
track1.selectSpecificTrack(track1);
