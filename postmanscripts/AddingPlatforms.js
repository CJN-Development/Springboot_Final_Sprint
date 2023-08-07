const platforms = [
    {
        "id": 1,
        "platformName": "PC"
    },
    {
        "id": 2,
        "platformName": "Xbox"
    },
    {
        "id": 3,
        "platformName": "PS4"
    },
    {
        "id": 4,
        "platformName": "Nintendo Switch"
    }
];

// Function to send a POST request for a single platform
function createPlatform(platform) {
    pm.sendRequest({
        url: 'http://localhost:8080/platform', // Replace this with your API endpoint for creating platforms
        method: 'POST',
        header: 'Content-Type:application/json',
        body: {
            mode: 'raw',
            raw: JSON.stringify(platform)
        }
    }, function (err, response) {
        if (err) {
            console.error(err);
        } else {
            console.log('Platform created:', platform);
        }
    });
}

// Loop through the platforms array and call createPlatform for each one
for (let i = 0; i < platforms.length; i++) {
    createPlatform(platforms[i]);
}