$(document).ready(


);

function getWeather() {


    $('#weatherDisplay').hide();
    $('#cityName').empty();
    $('#currentImage').empty();
    $('#currentList').empty();
    for (i = 0; i < 5; i++) {
        $('#day-' + i + '-date').empty();
        $('#day-' + i + '-pic').empty();
        $('#day-' + i + '-descrip').empty();
        $('#day-' + i + '-weather').empty();
    }


    var hasValidationErrors = checkAndDisplayValidation($('#weather-form').find('input'));

    if (hasValidationErrors) {
        return false;
    }


    var zipcode = $('#zipcode').val();
    var units = $('#units').val().toLowerCase();

    var key = '7044fc3b393ac0780aa88392b07c0a1e';

    if (units == 'imperial') {
        var unitsSymbol = ' F';
    } else {
        var unitsSymbol = ' C';
    }


    //             CALL FOR CURRENT WEATHER    -----------------------------------------------------            
    $.ajax({
        type: 'GET',
        url: 'http://api.openweathermap.org/data/2.5/weather?zip=' + zipcode + ',us&units=' + units + '&APPID=' + key,

        success: function (weatherArray) {

            $('#errorMessages').empty();

           
            $('#weatherDisplay').show();



            var name = weatherArray.name;

            $('#cityName').append('Current Conditions in' + ' ' + name);

            //Weather is an array of items
            $.each(weatherArray.weather, function (index, weatherParameter) {

                var iconUrl = weatherParameter.icon;
                var iconDescription = weatherParameter.description;
                $('#currentImage').append('<p><img src="http://openweathermap.org/img/w/' + iconUrl + '.png"/>' + ' ' + iconDescription + '</p>');
            });

            //Main is an object with properties.
            var temperature = weatherArray.main.temp;
            var humidity = weatherArray.main.humidity;
            var wind = weatherArray.wind.speed;



            $('#currentList').append('<li> Temperature: ' + temperature + unitsSymbol + '</li>' +
                '<li> Humidity: ' + humidity + ' % </li>' +
                '<li> Wind: ' + wind + ' miles/hour </li>');
        },

        error: function () {

            $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' }).text('Error on server-side. Zipcode may not exist.'));
        }

    });

    //            CALL FOR 5 DAY FORECAST -------------------------------------------------
    $.ajax({
        type: 'GET',
        url: 'http://api.openweathermap.org/data/2.5/forecast/daily?zip=' + zipcode + ',us&units=' + units + '&APPID=' + key,

        success: function (forecastArray) {
            
            var datesFromApi = [];
            var iconUrls = [];
            var descriptions = [];
            var highs = [];
            var lows = [];
            //loop through list array for dates
            $.each(forecastArray.list, function (index, listParameter) {



                var date = new Date(listParameter.dt * 1000);
                var options1 = { day: 'numeric' };
                var options2 = { month: 'long' };

                var formattedDate = date.toLocaleDateString('en-US', options1) + ' ' + date.toLocaleDateString('en-US', options2);

                var high = listParameter.temp.max;
                var low = listParameter.temp.min;

                datesFromApi.push(formattedDate);
                highs.push(high);
                lows.push(low);
                //loop through weather array for icons

                $.each(listParameter.weather, function (index, weatherParameter) {

                    var icon = weatherParameter.icon;
                    var descrip = weatherParameter.main;

                    iconUrls.push(icon);
                    descriptions.push(descrip);

                });

            });

            for (i = 0; i < 5; i++) {
                $('#day-' + i + '-date').append(datesFromApi[i]);
                $('#day-' + i + '-pic').append('<img src="http://openweathermap.org/img/w/' + iconUrls[i] + '.png"/>');
                $('#day-' + i + '-descrip').append(descriptions[i]);
                $('#day-' + i + '-weather').append('H ' + highs[i] + ' ' + unitsSymbol + ' L ' + lows[i] + ' ' + unitsSymbol);
            }



        },

        error: function () {
            $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' }).text('Error on server-side for 5-day forecast.'));
        }
    });

    $('#zipcode').val('');

}





function checkAndDisplayValidation(input) {
    $('#errorMessages').empty();

    var errorMessages = [];

    input.each(function () {
        if (!this.validity.valid) {

            var errorField = $('label[for=zipcode]').text();

            errorMessages.push(errorField + ': Please enter a 5-digit zipcode.');
        }


    }
    )
        ;



    if (errorMessages.length > 0) {

        $.each(errorMessages, function (index, message) {
            $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' }).text(message))
        });
        return true;
    } else {
        return false;
    }




}

