//Pong Paddle CLass


var PongPaddle = function(context, pongCanvasWidth, pongCanvasHeight, posX, posY) {
    this.context = context;
    this.pongCanvasWidth = pongCanvasWidth;
    this.pongCanvasHeight = pongCanvasHeight;
    this.posX = posX;
    this.posY = posY;
    this.up = false;
    this.down = false;
};

//PongPaddle Methods

//Draw PongPaddles
PongPaddle.prototype.renderPaddle = function() {

    this.context.fillStyle = 'white';
    this.context.fillRect(this.posX, this.posY, 10, 70);

};


//Move Paddle Up
PongPaddle.prototype.moveUp = function() {

    console.log('Up');
    if (this.posY <= 5)
        this.posY = 5;
    else this.posY -= 40;

};


//Move Paddle Down


PongPaddle.prototype.moveDown = function() {

    console.log('Down');
    if (this.posY >= this.pongCanvasHeight - 110) // height of paddle + velocity 70 + 40
        this.posY = this.pongCanvasHeight - 80;
    else this.posY += 40;

};
