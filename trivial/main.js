console.log('hello');

var Trivial = function() {
    this.question = [];
    this.currentQuestionIndex = 0;
    this.players = [];
    this.currentPlayerIndex = 0;
    this.selectedCategory = "";

};

Trivial.prototype.askQuestion = function(currentQuestionIndex) {

    console.log(this.selectedCategory);

    if (this.question[currentQuestionIndex].category === this.selectedCategory) {

        var result = prompt("Question for " + this.players[this.currentPlayerIndex].playerName + "\n" +
            this.question[this.currentQuestionIndex].title + "\n" +
            this.question[this.currentQuestionIndex].choices.join("\n"));

        if (result.toUpperCase() === this.question[this.currentQuestionIndex].correctAns) {
            alert("Congratulations");
            this.players[this.currentPlayerIndex].score++;

        } else {
            alert("Wrong Answer");
        }
        //Incrementing no: of Questions answered
        this.players[this.currentPlayerIndex].numQuestionsAnswered++;
    } else {

        if (currentQuestionIndex + 1 < this.question.length) {
            currentQuestionIndex++;
            this.currentQuestionIndex++;

            this.askQuestion(currentQuestionIndex);
            console.log('Iam here' + currentQuestionIndex);
        }
    }

};

Trivial.prototype.addQuestion = function(q) {
    this.question.push(q);

};

//Add shuffle feature of the questions every time you start a new round

Trivial.prototype.shuffleQuestions = function() {

    var counter = this.question.length;
    var temp = {};

    for (var i = this.question.length; i > 0; i--) {

        counter--;

        var j = Math.floor(Math.random() * counter);

        temp = this.question[counter];
        this.question[counter] = this.question[j];
        this.question[j] = temp;
    }

};


Trivial.prototype.play = function() {

    var response = prompt("1. Play Normally" + "\n" + "2. Play in Mode");

    console.log('Starting to ask Questions...');

    if (this.currentQuestionIndex === 0) {
        this.shuffleQuestions();
        this.selectCategory();
        alert("Selected category is " + this.selectedCategory);

    }

    if (response === "1") {

        this.askQuestion(this.currentQuestionIndex);

        if (this.currentPlayerIndex + 1 < this.players.length) {
            ++this.currentPlayerIndex;
            console.log(this.currentPlayerIndex);
        } else {
            this.currentPlayerIndex = 0;
        }

        ++this.currentQuestionIndex;

        if (this.currentQuestionIndex < this.question.length) {
            this.play();
        } else {

            alert("Game Over!!");
            this.currentPlayerIndex = 0;
            while (this.currentPlayerIndex < this.players.length) {
                this.players[this.currentPlayerIndex].printScore();
                ++this.currentPlayerIndex;
            }

            this.congratulateWinner();

        }
    } else if (response === "2") {

        while (this.currentPlayerIndex < this.players.length) {

            while (this.currentQuestionIndex < this.question.length) {
                this.askQuestion(this.currentQuestionIndex);
                ++this.currentQuestionIndex
            }
            this.currentQuestionIndex=0;
            ++this.currentPlayerIndex;
        }
        alert("Game Over!!");
        this.currentPlayerIndex = 0;
        while (this.currentPlayerIndex < this.players.length) {
            this.players[this.currentPlayerIndex].printScore();
            ++this.currentPlayerIndex;
        }

        this.congratulateWinner();
    } else {

        alert("Invalid Choice!!!!");
    }



};

Trivial.prototype.selectCategory = function() {

    var categories = [];
    var ct = "";

    for (var i = 0; i < this.question.length; i++) {

        if (!categories.includes(this.question[i].category)) {

            categories.push(this.question[i].category);
            ct = ct.concat("\n", this.question[i].category);
        } else {
            continue;
        }
    }

    var response = prompt("Select the category !" + ct);
    this.selectedCategory = response;

};




Trivial.prototype.addPlayer = function(player) {

    this.players.push(player);

};

Trivial.prototype.congratulateWinner = function() {

    var winnerArray = [];

    var winner = this.players[0];

    for (var i = 0; i < this.players.length; i++) {

        if (((this.players[i].score / this.players[i].numQuestionsAnswered) * 100) >
            ((winner.score / winner.numQuestionsAnswered) * 100)) {

            winner = this.players[i];

            while (winnerArray.length = 0) {
                winnerArray.pop();
            }

            winnerArray.push(winner);
        } else if (((this.players[i].score / this.players[i].numQuestionsAnswered) * 100) ===
            ((winner.score / winner.numQuestionsAnswered) * 100)) {

            winnerArray.push(this.players[i]);

        } else {
            continue;
        }

    }
    if (winnerArray.length > 1) {
        alert("There is a tie!!!");
    }
    for (var i = 0; i < winnerArray.length; i++) {
        alert("Congratulations " + winnerArray[i].playerName + " !");
    }
};


Trivial.prototype.setPlayers = function() {

    alert("Add Player Names");
    var response = "Dummy";
    var playerNameArray = [];

    while (response !== "") {
        response = prompt("Enter Player Name");
        playerNameArray.push(response);

    }

    playerNameArray.pop();

    for (var i = 0; i < playerNameArray.length; i++) {

        var playerObj = new Players(playerNameArray[i]);
        this.addPlayer(playerObj);
    }


    console.log(playerNameArray);

};

var Question = function(title, choices, correctAns, category) {
    this.title = title;
    this.choices = choices;
    this.correctAns = correctAns;
    this.category = category;
};

var Players = function(playerName) {
    this.playerName = playerName;
    this.numQuestionsAnswered = 0;
    this.score = 0;
};

Players.prototype.printScore = function() {

    alert("Name : " + this.playerName + "\n" + "Score : " + this.score + "\n" +
        "Number of Questions answered : " + this.numQuestionsAnswered);

};


//Creating instance Trivial
var t1 = new Trivial();

//Creating instance Question
var question1 = new Question('Capital of France', ['A - Paris', 'B - Rome'], 'A', 'Europe');
var question2 = new Question('Capital of India', ['A - Delhi', 'B - Bombay'], 'A', 'Asia');
var question3 = new Question('Capital of Switzerland', ['A - Geneva', 'B - Bern'], 'B', 'Europe');
var question4 = new Question('Capital of China', ['A - Beijing', 'B - Shanghai'], 'A', 'Asia');
var question5 = new Question('Capital of Japan', ['A - Tokyo', 'B - Taiwan'], 'A', 'Asia');
var question6 = new Question('Capital of Indonesia', ['A - Jakarta', 'B - Timbuktu'], 'A', 'Asia');
var question7 = new Question('Capital of Rome', ['A - Italy', 'B - Ticino'], 'A', 'Europe');

//Adding Questions
t1.addQuestion(question1);
t1.addQuestion(question2);
t1.addQuestion(question3);
t1.addQuestion(question4);
t1.addQuestion(question5);
t1.addQuestion(question6);
t1.addQuestion(question7);



t1.setPlayers();

//Players

/*var player1 = new Players('Amy');
t1.addPlayer(player1);
var player2 = new Players('Bob');
t1.addPlayer(player2);
var player3 = new Players('Susy');
t1.addPlayer(player3);
*/

// Handling all questions
t1.play();

//t1.shuffleQuestions();
