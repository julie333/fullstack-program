//Block Class
var Block = function(posX, posY) {

    this.positionX = posX;
    this.positionY = posY;
    this.height = 40;
    this.width = 40;
    this.color = '#' + (Math.random() * 0xFFFFFF << 0).toString(16);
};

//Block Methods

//Render Blocks
Block.prototype.renderBlock = function(context) {

    context.fillStyle = this.color;
    context.fillRect(this.positionX, this.positionY, 30, 30);
};


