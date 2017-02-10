//Get Canvas
var canvas = document.getElementById('pongCanvas');

//Game Class
var Game = function(pongCanvas) {

    this.pongCanvas = pongCanvas;
    this.ctx = pongCanvas.getContext('2d');
    this.scoreL = 0;
    this.scoreR = 0;
    this.pongBall = new PongBall(this.ctx);
    this.pongPaddleL = new PongPaddle(this.ctx, this.pongCanvas.width, this.pongCanvas.height, 5, 5);
    this.pongPaddleR = new PongPaddle(this.ctx, this.pongCanvas.width, this.pongCanvas.height, this.pongCanvas.width - 15, 5);
    this.track = 0;
    this.imageObj = new Image();

};

//Play method
Game.prototype.play = function() {

    var self = this;
    self.addListenersPaddle();
    self.getPlayerNames();

    self.handle = setInterval(function() {
        self.resetCanvas();
        self.drawLine();
        self.pongPaddleL.renderPaddle();
        self.pongPaddleR.renderPaddle();
        self.checkPongPaddleCollision();
        self.pongBall.moveBall(self.pongCanvas.height, self.pongCanvas.width);
        self.pongBall.renderBall();
        self.displayScore();
        self.keepScore();

    }, 16);

};

Game.prototype.playSound = function(trackNumber) {

    var pool = [new Audio("Bounce.mp3"), new Audio("applause.mp3"), new Audio("pling.wav")];

    pool[trackNumber].volume = .1;
    pool[trackNumber].load();
    pool[trackNumber].play();
};

//Get Player Names
Game.prototype.getPlayerNames = function() {

    this.player1Name = prompt("Enter Player 1 Name");
    this.player2Name = prompt("Enter Player 1 Name");
};


//Display Score
Game.prototype.displayScore = function() {

    this.ctx.fillStyle = "white";
    this.ctx.font = "bold 12px Calibri";
    this.ctx.fillText(this.scoreL, Math.floor(this.pongCanvas.width / 2) - 20, 15);
    this.ctx.fillText(this.scoreR, Math.floor(this.pongCanvas.width / 2) + 15, 15);


};

//Add Listeners to each Paddle
Game.prototype.addListenersPaddle = function() {

    var self = this;

    document.addEventListener('keydown', function(event) {
        console.log('you pressed a key!');
        console.log(event.key);
        if (event.key === "a") {

            self.pongPaddleL.up = true;
            self.pongPaddleL.down = false;
            self.pongPaddleL.moveUp();


        } else if (event.key === "d") {

            self.pongPaddleL.up = false;
            self.pongPaddleL.down = true;
            self.pongPaddleL.moveDown();

        }

    });

    document.addEventListener('keydown', function(event) {
        console.log('you pressed a key!');
        console.log(event.key);
        if (event.key === "j") {
            self.pongPaddleR.moveUp();
            //up === true;
        } else if (event.key === "l") {
            self.pongPaddleR.moveDown();
            //down === true;
        }

    });
};


//Reset Canvas
Game.prototype.resetCanvas = function() {

    this.ctx.fillStyle = 'black';
    this.ctx.fillRect(0, 0, this.pongCanvas.width, this.pongCanvas.height);
};


//Reset Canvas if Ball hits outside paddle
Game.prototype.resetPaddleCanvas = function(start, width) {

    this.ctx.fillStyle = 'red';
    this.ctx.fillRect(start, 0, width, this.pongCanvas.height);
};

//Draw Lines method
Game.prototype.drawLine = function() {

    this.ctx.beginPath();
    this.ctx.setLineDash([5, 3]);
    this.ctx.moveTo(Math.floor(this.pongCanvas.width / 2), 0);
    this.ctx.lineTo(Math.floor(this.pongCanvas.width / 2), this.pongCanvas.height);
    this.ctx.strokeStyle = "green";
    this.ctx.stroke();

};

//Check Pong Paddle Collision
Game.prototype.checkPongPaddleCollision = function() {

    /*if ((this.pongBall.initialPos[1] > this.pongPaddleL.posY) &&
        (this.pongBall.initialPos[1] < this.pongPaddleL.posY + 70) &&
        (this.pongBall.initialPos[0] <= this.pongPaddleL.posX + 4)) // Inside Left Condition

    {
        this.pongBall.initialPos[0] += 10;
        this.pongBall.velocity[0] = -this.pongBall.velocity[0];

    } else if ((this.pongBall.initialPos[1] > this.pongPaddleL.posY) &&
        (this.pongBall.initialPos[1] < this.pongPaddleL.posY + 70) &&
        (this.pongBall.initialPos[0] <= this.pongPaddleR.posX + 4)) // Inside Right Condition

    {
        this.pongBall.initialPos[0] -= 10;
        this.pongBall.velocity[0] = -this.pongBall.velocity[0];

    } else*/

     if ((this.pongBall.initialPos[1] > this.pongPaddleL.posY) &&
        (this.pongBall.initialPos[1] < this.pongPaddleL.posY + 70) &&
        (this.pongBall.initialPos[0] <= this.pongPaddleL.posX + 10 + 4)) //size of paddle + radius of ball
    {

        this.playSound(0);
        this.pongBall.velocity[0] = -this.pongBall.velocity[0];
        this.track++;

    } else if ((this.pongBall.initialPos[1] > this.pongPaddleR.posY) &&
        (this.pongBall.initialPos[1] < this.pongPaddleR.posY + 70) &&
        (this.pongBall.initialPos[0] >= this.pongPaddleR.posX - 10)) {

        this.playSound(0);
        this.pongBall.velocity[0] = -this.pongBall.velocity[0];

        this.track++;

    } else if (this.track > 5) {

        this.track = 0;
        this.pongBall.velocity[0] *= 1.1;
        this.pongBall.velocity[1] *= 1.1;
    }
};

//To keep Score
Game.prototype.keepScore = function() {


    if (this.scoreL >= 10 || this.scoreR >= 10) {
        var winner = "";

        if (this.scoreL === this.scoreR) {
            alert("Tie!!");
            winner = this.player1Name + " " + this.player2Name;

        } else if (this.scoreL > this.scoreR)
            winner = this.player1Name;
        else
            winner = this.player2Name;

        //Set background Image and Game Over Text
        this.imageObj.src = 'gameOver.jpg';

        var self = this;
        this.imageObj.onload = function() {

            self.ctx.drawImage(self.imageObj, 0, 0, self.pongCanvas.width, self.pongCanvas.height);

            self.ctx.fillStyle = "orangered"; //'#' + (Math.random() * 0xFFFFFF << 0).toString(16);
            self.ctx.font = "40px Impact";
            self.ctx.textAlign = 'center';

            self.ctx.fillText("# GAME OVER #", Math.floor(self.pongCanvas.width / 2), Math.floor(self.pongCanvas.height / 2) - 50);
            self.ctx.fillText(winner + " HAS WON !!", Math.floor(self.pongCanvas.width / 2), Math.floor(self.pongCanvas.height / 2 + 50));

        };

        this.playSound(1);

        clearInterval(this.handle);

    } else {
        if (this.pongBall.initialPos[0] >= this.pongCanvas.width - 4) {

            this.resetPaddleCanvas(Math.floor(this.pongCanvas.width / 2), Math.floor(this.pongCanvas.width / 2));
            this.scoreL++;
            this.playSound(2);

            this.pongBall.velocity[0] = -this.pongBall.velocity[0];


        } else if (this.pongBall.initialPos[0] <= 4) {

            this.resetPaddleCanvas(0, Math.floor(this.pongCanvas.width / 2));
            this.scoreR++;
            this.playSound(2);

            this.pongBall.velocity[0] = -this.pongBall.velocity[0];

        }
    }

};

//Main

var g = new Game(canvas);
g.play();
