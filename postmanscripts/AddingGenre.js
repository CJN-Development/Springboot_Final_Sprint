const genres = [
    {
        "id": 1,
        "genreName": "Role-Playing"
    },
    {
        "id": 2,
        "genreName": "Adventure"
    },
    {
        "id": 1,
        "genreName": "Action"
    },
    {
        "id": 1,
        "genreName": "Survival"
    },
    {
        "id": 1,
        "genreName": "Puzzle"
    },
    {
        "id": 1,
        "genreName": "Simulation"
    },
    {
        "id": 1,
        "genreName": "Strategy"
    },



];

// Function to send a POST request for a single genre
function createGenre(genre) {
    pm.sendRequest({
        url: 'http://localhost:8080/genre', // Replace this with your API endpoint
        method: 'POST',
        header: 'Content-Type:application/json',
        body: {
            mode: 'raw',
            raw: JSON.stringify(genres)
        }
    }, function (err, response) {
        if (err) {
            console.error(err);
        } else {
            console.log('Genre created:', genre);
        }
    });
}

// Loop through the genre array and call createGenre for each one
for (let i = 0; i < genres.length; i++) {
    createGenre(genres[i]);
}