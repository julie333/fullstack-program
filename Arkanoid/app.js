//Get Canvas
var canvas = document.getElementById('bricksCanvas');

//Game Class
var Game = function(gameCanvas) {

    this.gameCanvas = gameCanvas;
    this.ctx = gameCanvas.getContext('2d');
    this.ball1 = new Ball(this.ctx);
    this.blocks = [];
    this.paddle = new Paddle(this.ctx, this.gameCanvas.width, this.gameCanvas.height);
    this.handle;
    this.score = 0;
};

//Game Methods

//Create Blocks
Game.prototype.createBlocks = function() {

    var y = 40;

    for (var i = 0; i < 4; i++) {
        var x = 30;
        for (var j = 0; j < 7; j++) {

            var block = new Block(x, y);
            this.blocks.push(block);
            x += 35;
        }
        y += 35;
    }
};

//Reset Canvas
Game.prototype.resetCanvas = function() {

    this.ctx.fillStyle = 'black';
    // this.ctx.strokeStyle = 'red';
    // this.ctx.strokeRect(0, 0, this.gameCanvas.width, this.gameCanvas.height);
    this.ctx.fillRect(0, 0, this.gameCanvas.width, this.gameCanvas.height);

};

//Play method
Game.prototype.play = function() {

    var self = this;
    self.createBlocks();

    self.handle = setInterval(function() {
        self.resetCanvas();
        self.paddle.renderPaddle();
        self.ball1.moveBall(self.gameCanvas.height, self.gameCanvas.width);
        self.ball1.renderBall();
        self.checkPaddleCollision();
        self.checkCollisions();
        self.blocks.forEach(function(element) {
            element.renderBlock(self.ctx);
        });

    }, 5);
};

//Check collisions

Game.prototype.checkCollisions = function() {

    var self = this;
    var flag = 1;

    self.blocks.forEach(function(element, index) {

        if ((self.ball1.initialPos[0] + 5 < element.positionX + element.width) &&
            (self.ball1.initialPos[0] - 5 > element.positionX) &&
            (self.ball1.initialPos[1] - 7 < element.positionY + element.height) &&
            (self.ball1.initialPos[1] - 5 > 50)) {


            if (self.ball1.initialPos[1] - 7 < element.positionY + element.height) {
                self.blocks.splice(index, 1);
                self.score++;
                self.ball1.velocity[1] = -self.ball1.velocity[1];

            }

        }
    });
};


Game.prototype.checkPaddleCollision = function() {

    console.log(this.paddle.initialPaddlePos);

    if ((this.ball1.initialPos[1] + 10 > this.gameCanvas.height - 30) &&
        (this.ball1.initialPos[0] + 10 > this.paddle.initialPaddlePos && this.ball1.initialPos[0] < this.paddle.initialPaddlePos + 80)) {

        console.log('colliding paddle');

        this.ball1.velocity[1] = -this.ball1.velocity[1];

    } else if (this.ball1.initialPos[1] + 10 === this.gameCanvas.height) {

        console.log('outside paddle');
        clearInterval(this.handle);

        alert("Game Over!!");

    }

};

//Main

var g = new Game(canvas);
g.play();
