const games = [
    {
        "name":"Red Dead Redemption",
        "releaseDate":"09/11/2018",
        "gamePublisher":"Rockstar Games",
        "platforms":[
            {
                "platformName":"Xbox"
            },
            {
                "platformName":"PC"
            },
            {
                "platformName": "Playstation"
            }
        ],
         "genres":[
            {
                "genreName":"RPG"

            },
            {
                "genreName":"FPS"

            }

        ]

    },
    {
            "name":"Red Dead Redemption",
            "releaseDate":"09/11/2018",
            "gamePublisher":"Rockstar Games",
            "platforms":[
                {
                    "platformName":"Xbox"
                },
                {
                    "platformName":"PC"
                },
                {
                    "platformName": "Playstation"
                }
            ],
             "genres":[
                {
                    "genreName":"RPG"
                },
                {
                    "genreName":"FPS"
                }
            ]
        }
];

// Function to send a POST request for a single genre
function createGame(game) {
    pm.sendRequest({
        url: 'http://localhost:8080/create/createGame', // Replace this with your API endpoint
        method: 'POST',
        header: 'Content-Type:application/json',
        body: {
            mode: 'raw',
            raw: JSON.stringify(gamer)
        }
    }, function (err, response) {
        if (err) {
            console.error(err);
        } else {
            console.log('Game created:', game);
        }
    });
}

// Loop through the genre array and call createGenre for each one
for (let i = 0; i < games.length; i++) {
    createGame(games[i]);
}