// Ball Class
var Ball = function(context) {

    this.context = context;
    this.radius = 10;
    this.initialPos = [0, 370];
    this.velocity = [2, 1];
    this.flag = 0;
};

//Ball Methods

//Draw Ball
Ball.prototype.renderBall = function() {

    this.context.beginPath();
    this.context.arc(this.initialPos[0], this.initialPos[1], this.radius, 2 * Math.PI, false);
    this.context.fillStyle = "indianred";
    this.context.fill();
};

//Move Ball
Ball.prototype.moveBall = function(canvasHeight, canvasWidth) {

    let posX = this.initialPos[0] + this.velocity[0];
    let posY = this.initialPos[1] + this.velocity[1];

    if (posX > canvasWidth)
        this.velocity[0] = -this.velocity[0];

    else if (posX < 0)
        this.velocity[0] = -this.velocity[0];

    else if (posY > canvasHeight)
        this.velocity[1] = -this.velocity[1];

    else if (posY < 0)
        this.velocity[1] = -this.velocity[1];

    else {

        this.initialPos[0] += this.velocity[0];
        this.initialPos[1] += this.velocity[1];
    }
};
