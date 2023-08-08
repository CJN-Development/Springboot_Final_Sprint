
/*TODO: Can only send script with 2 fields not sure why, thinking it has to do with the game entity relationships and
where the lists populate from those relationships , maybe?*/

const games = [
    {
        "gameName": "Game 1",
        "releaseDate": "2023/08/08",

    },
    {
        "gameName": "Game 2",
        "releaseDate": "2023/08/09",

    },
    {
        "gameName": "Game 3",
        "releaseDate": "2023/08/10",
    },

];

// Function to send a POST request for a single game
function createGame(game) {
    pm.sendRequest({
        url: 'http://localhost:8080/game', // Replace this with your API endpoint
        method: 'POST',
        header: 'Content-Type:application/json',
        body: {
            mode: 'raw',
            raw: JSON.stringify(game)
        }
    }, function (err, response) {
        if (err) {
            console.error(err);
        } else {
            console.log('Game created:', game);
        }
    });
}

// Loop through the games array and call createGame for each one
for (let i = 0; i < games.length; i++) {
    createGame(games[i]);
}
