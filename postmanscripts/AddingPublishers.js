const publishers = [
    {
        "id": 1,
        "publisherName": "Square Enix"
    },
    {
        "id": 2,
        "publisherName": "Nintendo"
    },
    {
        "id": 3,
        "publisherName": "Activision Blizzard"
    },

    {
        "id": 4,
    "publisherName": "Electronic Arts (EA)"
    },
    {
        "id": 5,
    "publisherName": "Ubisoft"
    },
    {
        "id": 6,
    "publisherName": "Sony Interactive Entertainment"
    },
    {
        "id": 7,
    "publisherName": "Take-Two Interactive"
    },
    {
        "id": 8,
    "publisherName": "Bandai Namco Entertainment"
    },
    {
        "id": 9,
    "publisherName": "Capcom"
    },

];

// Function to send a POST request for a single publisher
function createPublisher(publisher) {
    pm.sendRequest({
        url: 'http://localhost:8080/publisher', // Replace this with your API endpoint
        method: 'POST',
        header: 'Content-Type:application/json',
        body: {
            mode: 'raw',
            raw: JSON.stringify(publisher)
        }
    }, function (err, response) {
        if (err) {
            console.error(err);
        } else {
            console.log('Publisher created:', publisher);
        }
    });
}

// Loop through the publishers array and call createPublisher for each one
for (let i = 0; i < publishers.length; i++) {
    createPublisher(publishers[i]);
}