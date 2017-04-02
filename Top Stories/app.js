$(function() {

    var token = "864ef329899045e79f4da7b768bfe974";
    var favourites = [];

    //Create The flexbox, Fetch Stories,Append
    var flexBox = $('<div>').addClass("columns");
    fetchTopStories();
    $("#container").append(flexBox);

    //Toggling the fav button
    flexBox.on('click', ".btn-primary", function(event) {

        event.preventDefault();
        var storyTitle = $(event.currentTarget).attr('id');

        var found = favourites.some(function(element) {
            return element.storyTitle === storyTitle;
        });

        if (!found) {
            favourites.push({ storyTitle: storyTitle, active: 1 });
            $(event.currentTarget).text('Remove Fav').addClass('indianred');
        } else {

            //Find the index of the element to remove
            var index = favourites
                .map(function(element) {
                    return element.storyTitle;
                })
                .indexOf(storyTitle);

            favourites.splice(index, 1);
            $(event.currentTarget).text('Fav').removeClass('indianred');
        }

        displayFavourites();
        console.log(favourites);
    });

    function fetchTopStories() {

        fetch('https://api.nytimes.com/svc/topstories/v2/home.json?api-key=' + token)
            .then(function(res) {
                return res.json();
            })
            .then(function(data) {

                flexBox.append(renderTitle());

                data.results.forEach(function(story, index) {

                    var storyTitle = story.title;
                    var abstract = story.abstract;
                    var image = story.multimedia.length > 0 ? story.multimedia[0].url : "story.jpg";

                    if (index < 8)
                        flexBox.append(renderStory(storyTitle, abstract, image));
                });

            });
    }

    function renderTitle() {

        var grid = $('<div>').addClass("titleBox");
        var card = $('<div>').html($('<img>').attr("src", "title.jpg"));
        var title = $('<div>').html($('<p>').text("#Top Stories").append(card));
        var obj = grid.append(title);
        return obj;
    }

    function renderStory(storyTitle, abstract, image) {

        var grid = $('<div>').addClass("column col-3");
        var button = $('<button>').addClass("btn btn-primary").text("Fav").attr('id', storyTitle);

        var card = $('<div>').addClass("card")
            .append($('<div>').addClass("card-header").html($('<h4>').addClass("card-title").text(storyTitle)))
            .append($('<div>').addClass("card-image").html($('<img>').addClass("img img-responsive").attr("src", image)))
            .append($('<div>').addClass("card-body").html($('<p>').text(abstract)))
            .append($('<div>').addClass("card-footer").append(button));

        var obj = grid.append(card);
        return obj;
    }

    function displayFavourites() {

        $(".table").empty();
        //Create Favourites Table & Heading

        var table = $('<table>').addClass("table table-striped table-hover favTable").attr('id', 'Favourites')
            .append($('<thead>')
                .append($('<tr>')
                    .append($('<th>').text("Favourite Stories - Titles"))));

        for (var i = 0; i < favourites.length; i++) {

            if (favourites[i].active === 1) {
                console.log(favourites[i].active);
                var body = $('<tbody>')
                    .append($('<tr>')
                        .append($('<td>').text(favourites[i].storyTitle)));

                table.append(body);
            }
        }
        $("#container").append(table);
    }
});
