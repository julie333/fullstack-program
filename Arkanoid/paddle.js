//Paddle CLass


var Paddle = function(context, gameCanvasWidth, gameCanvasHeight) {
    this.context = context;
    this.initialPaddlePos = 0;
    this.gameCanvasWidth = gameCanvasWidth;
    this.gameCanvasHeight = gameCanvasHeight;
    var self = this;
    document.addEventListener('keydown', function(event) {
        console.log('you pressed a key!');
        console.log(event.key);
        if (event.key === "a" || event.key === "j") {
            self.moveLeft();
        } else if (event.key === "d" || event.key === "l") {
            self.moveRight();
        }
    });

};

//Paddle Methods

//Draw Paddle
Paddle.prototype.renderPaddle = function() {

    this.context.fillStyle = 'steelblue';
    this.context.fillRect(this.initialPaddlePos, this.gameCanvasHeight - 20, 80, 10);
};

Paddle.prototype.moveLeft = function() {
    console.log('Left');

    if (this.initialPaddlePos > 0)
        this.initialPaddlePos -= 20;
    else
        this.initialPaddlePos = 0;



};

Paddle.prototype.moveRight = function() {
    console.log('Right');

    if (this.initialPaddlePos + 5 < this.gameCanvasWidth - 80)
        this.initialPaddlePos += 20;
    else
        this.initialPaddlePos = this.gameCanvasWidth - 80;
};



/*
As an example you could define moveLeft and moveRight methods on the Paddle that will change the position of the paddle.
Know when to stop the paddle from moving. The ball never stops. However, the paddle doesn't move unless you press the key.
Tip: play with two event types 'keydown' and 'keyup'. On 'keydown' you could make the paddle move. Then, on 'keydown' the paddle stops.
*/
