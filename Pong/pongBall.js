// Pong Ball Class
var PongBall = function(context) {

    this.context = context;
    this.radius = 4;
    this.initialPos = [100, 20];
    this.velocity = [3, 2];

};

//Pong Ball Methods

//Draw Pong Ball
PongBall.prototype.renderBall = function() {

    this.context.beginPath();
    this.context.arc(this.initialPos[0], this.initialPos[1], this.radius, 2 * Math.PI, false);
    this.context.fillStyle = "indianred";
    this.context.fill();
};

//Move Ball
PongBall.prototype.moveBall = function(canvasHeight, canvasWidth) {

    let posX = this.initialPos[0] + this.velocity[0];
    let posY = this.initialPos[1] + this.velocity[1];

    if (posY >= canvasHeight)
        this.velocity[1] = -this.velocity[1];

    else if (posY <= 0)
        this.velocity[1] = -this.velocity[1];

    else {

        this.initialPos[0] += this.velocity[0];
        this.initialPos[1] += this.velocity[1];
    }
};
