document.addEventListener("DOMContentLoaded", function () {
    const API_KEY = '7d2cd5829b263a003998693eb49f725a'
    const API_URL = 'https://api.openweathermap.org/data/2.5/weather';
    const cityInput = document.getElementById('cityInput');
    const getWeatherButton = document.getElementById('getWeatherButton');
    const weatherInfo = document.getElementById('weatherInfo');


    getWeatherButton.addEventListener('click', () => {
        const city = cityInput.value.trim();

        if (city) {
            const apiUrl = `${API_URL}?q=${city}&appid=${API_KEY}&units=metric`;

            fetch(apiUrl)
                .then((response) => response.json())
                .then((data) => {
                    const { name, main, weather } = data;
                    const temperature = main.temp;
                    const description = weather[0].description;

                    weatherInfo.innerHTML = `
                        <h2>Weather in ${name}:</h2>
                        <p>Temperature: ${temperature}°C</p>
                        <p>Description: ${description}</p>
                    `;
                })
                .catch((error) => {
                    console.error('Error fetching weather data:', error);
                    weatherInfo.innerHTML = 'Unable to fetch weather data.';
                });
        }
    });
});
