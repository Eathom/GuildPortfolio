$(document).ready(function () {


    loadItems();

});

function loadItems() {
    var itemLists = $('#items');

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/items',

        success: function (itemArray) {

            $.each(itemArray, function (index, item) {
                var number = item.id;
                var name = item.name;
                var price = item.price;
                var quantity = item.quantity;

                var listOfItems = '<li><div class="col-md-3"' +
                    'style="border: 2px solid black; margin:2%" onclick="selectItem(' + number + ')"> <p>'
                    + number + '<br> <span style="display: block; text-align: center">'
                    + name + '<br> $'
                    + price + '<br><br> Quantity Left: '
                    + quantity + '</p></span><p></p></div></li>';

                itemLists.append(listOfItems);
            });
        },
        error: function () {
            $('#messages-display').val('Error calling web service');
        },

    });
}

function selectItem(number) {
    $('#item-selected').val(number);
}

function addDollar() {
    var totalParsedMoney = addMoney(1.00);
    $('#money-display').val(totalParsedMoney.toFixed(2));
}


function addQuarter() {
    var totalParsedMoney = addMoney(.25);
    $('#money-display').val(totalParsedMoney.toFixed(2));
}

function addDime() {
    var totalParsedMoney = addMoney(.10);
    $('#money-display').val(totalParsedMoney.toFixed(2));
}

function addNickel() {
    var totalParsedMoney = addMoney(.05);
    $('#money-display').val(totalParsedMoney.toFixed(2));
}

function addMoney(moneyToAdd) {
    var moneyFromInput = $('#money-display').val();
    var parsedMoney = parseFloat(moneyFromInput);
    parsedMoney += parseFloat(moneyToAdd);
    return parsedMoney;
}


function checkValidation(input) {
    $('#message-display').val('');

    var errorMessages = [];
    input.each(function () {
        if (!this.validity.valid) {
            var errorField = $(this).attr('name');
            errorMessages.push(errorField);
        }
    });

    if (errorMessages.length > 0) {

        $.each(errorMessages, function (index, message) {
            var stringMessages = '';
            stringMessages += message;

            $('#messages-display').val(stringMessages);

        });


        return true;
    } else {
        return false;
    }

}

function makePurchase() {
    var hasItemError = checkValidation($('#messages-form').find('input'));

    if (!hasItemError) {
        $('#change-display').val('');
        var itemId = $('#item-selected').val();
        var moneyEntered = $('#money-display').val();


        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/money/' + moneyEntered + '/item/' + itemId,

            success: function (change) {
                var quarters = change.quarters;
                var dimes = change.dimes;
                var nickels = change.nickels;
                var pennies = change.pennies;

                var changeDisplay = '';

                $('#messages-display').val('Thank you!');

                if (quarters > 0) {
                    changeDisplay += quarters + ' Quarter(s) ';
                }
                if (dimes > 0) {
                    changeDisplay += dimes + ' Dime(s) ';
                }
                if (nickels > 0) {
                    changeDisplay += nickels + ' Nickel(s) ';
                }
                if (pennies > 0) {
                    changeDisplay += pennies + ' Penny/Pennies ';
                }

                $('#change-display').val(changeDisplay);

                $('#money-display').val(0);

                $('#make-purchase').prop('disabled', true);
                $('#add-dollar').prop('disabled', true);
                $('#add-quarter').prop('disabled', true);
                $('#add-dime').prop('disabled', true);
                $('#add-nickel').prop('disabled', true);
            },

            error: function (error) {
                var errorObject = JSON.parse(error.responseText);
                $('#messages-display').val(errorObject.message);
            }
        });
    }
}



function changeReturn() {
    //after successful purchase, money display will be 0, change will be returned and displayed in purchase function.
    //if nothing purchased, money display will be what was input, change will be from javascript function.

    var changeDisplay = '';
    var changeObject = calculateChange($('#money-display').val());

    $('#make-purchase').prop('disabled', false);
    $('#add-dollar').prop('disabled', false);
    $('#add-quarter').prop('disabled', false);
    $('#add-dime').prop('disabled', false);
    $('#add-nickel').prop('disabled', false);

    if (changeObject.quarters > 0) {
        changeDisplay += changeObject.quarters + ' Quarter(s) ';
    }
    if (changeObject.dimes > 0) {
        changeDisplay += changeObject.dimes + ' Dime(s) ';
    }
    if (changeObject.nickels > 0) {
        changeDisplay += changeObject.nickels + ' Nickel(s) ';
    }
    if (changeObject.pennies > 0) {
        changeDisplay += changeObject.pennies + ' Penny/Pennies ';
    }

    $('#change-display').val(changeDisplay);

    //resets values and reloads items
    $('#money-display').val(0);
    $('#messages-display').val('');
    $('#item-selected').val('');
    $('#items').empty();
    loadItems();
}

function calculateChange(moneyEntered) {
    //convert decimals to whole numbers
    var change = moneyEntered * 100;
    var numOfQuarters = 0;
    var numOfDimes = 0;
    var numOfNickels = 0;
    var numOfPennies = 0;

    var remainder = 0;

    if ((change / 25) >= 1) {
        numOfQuarters = Math.floor(change / 25);
        remainder = change % 25;

        if ((remainder / 10) >= 1) {
            numOfDimes = Math.floor(remainder / 10);
            remainder = remainder % 10;

        }
        if ((remainder / 5) >= 1) {
            numOfNickels = Math.floor(remainder / 5);
            remainder = remainder % 5;
        }

    } else if ((change / 10) >= 1) {
        numOfDimes = Math.floor(change / 10);
        remainder = change % 10;

        if ((remainder / 5) >= 1) {
            numOfNickels = Math.floor(remainder / 5);
            remainder = remainder % 5;
        }

    } else if ((change / 5) >= 1) {
        numOfNickels = Math.floor(change / 5);
        remainder = change % 5;

    } else {
        remainder = change;
    }

    numOfPennies = remainder;

    var moneyOut = { quarters: numOfQuarters, dimes: numOfDimes, nickels: numOfNickels, pennies: numOfPennies };

    return moneyOut;
}

