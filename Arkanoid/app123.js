function getRandomColor() {
  const randomColors = [
    'red',
    'orange',
    'purple',
    'yellow',
    'pink',
    'blue',
    'green'
  ];

  const randomIndex = Math.floor(Math.random() * randomColors.length);
  return randomColors[randomIndex];
}

const Ball = function() {
  this.pos = [5, 35];
  this.radius = 1;
  this.vel = [0.1, -0.1];
}

Ball.prototype.move = function(height, width) {
  let newPosX = this.pos[0] + this.vel[0];
  if (newPosX < 0 + this.radius) {
    this.pos[0] = 0 + this.radius;
    this.vel[0] = -this.vel[0];
  } else if (newPosX > width - this.radius) {
    this.pos[0] = width - this.radius;
    this.vel[0] = -this.vel[0];
  } else {
    this.pos[0] = newPosX;
  }

  let newPosY = this.pos[1] + this.vel[1];
  if (newPosY < 0 + this.radius) {
    this.pos[1] = 1;
    this.vel[1] = -this.vel[1];
  } else if (newPosY > height - this.radius) {
    this.pos[1] = height - this.radius;
    this.vel[1] = -this.vel[1];
  } else {
    this.pos[1] = newPosY;
  }
}

Ball.prototype.render = function(context) {
  context.beginPath();
  context.arc(this.pos[0], this.pos[1], this.radius, 0, 2 * Math.PI, false);
  context.fillStyle = '#fff';
  context.fill();
}

const Block = function(id, row, col, offset) {
  this.id = id;
  this.width = 6;
  this.height = 2;
  this.color = getRandomColor();
  const xPos = row * this.width + offset.x;
  const yPos = col * this.height + offset.y;
  this.pos = [xPos, yPos];
}

Block.prototype.render = function(context) {
  context.fillStyle = this.color;
  context.fillRect(this.pos[0], this.pos[1], this.width, this.height);
}

const Game = function(canvas) {
  this.canvas = canvas;
  this.context = canvas.getContext('2d');
  const scale = 10;
  this.context.scale(scale, scale);
  this.height = canvas.height / scale;
  this.width = canvas.width / scale;
  this.ball = new Ball();
  this.blocks = this.createInitialBlock();
}

Game.prototype.createInitialBlock = function() {
  let currentIndex = 1;
  const blocks = [];
  for (let i = 0; i < 4; i++) {
    for (let j = 0; j < 4; j++) {
      const newBlock = new Block(currentIndex, i, j, { x: 3, y: 4 })
      blocks.push(newBlock);
      currentIndex++;
    }
  }

  return blocks;
}

Game.prototype.play = function() {
  const game = this;
  setInterval(function() {
    game.ball.move(game.height, game.width);
    game.render();
  }, 10);
}

Game.prototype.render = function() {
  this.reset();
  this.blocks.forEach(block => block.render(this.context));
  this.ball.render(this.context);
}

Game.prototype.reset = function() {
  this.context.fillStyle = '#000';
  this.context.fillRect(0, 0, this.width, this.height);
}

const canvas = document.getElementById('canvas');

const wall = new Game(canvas);
wall.play();