$(document).ready(function () {


});



function deleteDvd(dvdId) {
    if (confirm('Are you sure you want to delete?')) {
        $.ajax({
            type: 'DELETE',
            url: 'http://localhost:8080/dvd/' + dvdId,

            success: function () {
                alert('Dvd deleted');
            },
            error: function () {
                $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' }).text('Error deleting dvd'));
            }
        });


    }
}

function createDvd() {
    $('#errorMessages').empty();
    $('#tableDiv').hide();
    $('#addFormDiv').show();
}

function cancelAdd() {
    $('#edit-title').val('');
    $('#edit-year').val('');
    $('#edit-director').val('');
    $('#edit-rating').val('');
    $('#edit-notes').val('');
    $('#edit-dvdId').val('');


    $('#editFormDiv').hide();
    $('#tableDiv').show();

}

function addDvd() {
    var haveErrors = validate($('#add-form').find('input, select'));

    if (haveErrors) {
        return false;
    }
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/dvd',

        data: JSON.stringify({
            title: $('#add-title').val(),
            releaseYear: $('#add-year').val(),
            director: $('#add-director').val(),
            rating: $('#add-rating').val(),
            notes: $('#add-notes').val()

        }),

        headers: {
            'ACCEPT': 'application/json',
            'Content-Type': 'application/json'
        },

        'dataType': 'json',

        success: function () {
            $('#errorMessages').empty();


            $('#add-title').val('');
            $('#add-year').val('');
            $('#add-director').val('');
            $('#add-rating').val('');
            $('#add-notes').val('');
            $('#add-dvdId').val('');


            $('#addFormDiv').hide();
            $('#tableDiv').show();
        },
        error: function () {
            $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' }).text('Could not add'));
        }
    });


}

function editDvd(dvdId) {
    // SHOW FORM, THEN HIDE FORM IN SEPERATE FUNCTIONS
    $('#errorMessages').empty();
    $('#tableDiv').hide();
    $('#editFormDiv').show();


    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dvd/' + dvdId,

        success: function (dvd, status) {
            $('#editHeader').append(dvd.title);

            $('#edit-title').val(dvd.title);
            $('#edit-year').val(dvd.releaseYear);
            $('#edit-director').val(dvd.director);
            $('#edit-rating').val(dvd.rating);
            $('#edit-notes').val(dvd.notes);
            $('#edit-dvdId').val(dvd.dvdId);

        },
        error: function () {
            $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' }).text('Error getting edit information'));
        }
    });

}

function cancelEdit() {
    $('#edit-title').val('');
    $('#edit-year').val('');
    $('#edit-director').val('');
    $('#edit-rating').val('');
    $('#edit-notes').val('');
    $('#edit-dvdId').val('');


    $('#editFormDiv').hide();
    $('#tableDiv').show();

}

function saveEdit() {
    var dvdId = $('#edit-dvdId').val();
    var haveErrors = validate($('#edit-form').find('input, select'));
    if (haveErrors) {
        return false;
    }
    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/dvd/' + dvdId,

        data: JSON.stringify({
            dvdId: $('#edit-dvdId').val(),
            title: $('#edit-title').val(),
            releaseYear: $('#edit-year').val(),
            director: $('#edit-director').val(),
            rating: $('#edit-rating').val(),
            notes: $('#edit-notes').val()

        }),

        headers: {
            'ACCEPT': 'application/json',
            'Content-Type': 'application/json'
        },

        'dataType': 'json',

        success: function () {
            $('#errorMessages').empty();

            $('#edit-title').val('');
            $('#edit-year').val('');
            $('#edit-director').val('');
            $('#edit-rating').val('');
            $('#edit-notes').val('');
            $('#edit-dvdId').val('');


            $('#editFormDiv').hide();
            $('#tableDiv').show();
        },
        error: function () {
            $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' }).text('Could not update'));
        }
    });

}


function search() {

    $('#contentRows').empty();
    var haveErrors = validate($('#search-dvd-form').find('input, select'));
    if (haveErrors) {
        return false;
    }

    var category = $('#search-category').val();
    var term = $('#search-term').val();

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dvds/' + category + '/' + term,

        success: function (dvdArray) {
            $('#errorMessages').empty();
            if (dvdArray.length > 0) {

                $.each(dvdArray, function (index, dvd) {
                    var dvdId = dvd.dvdId;
                    var title = dvd.title;
                    var releaseYear = dvd.releaseYear;
                    var director = dvd.director;
                    var rating = dvd.rating;

                    $('#contentRows').append('<tr><td><a onclick="viewDvd(' + dvdId + ')">' + title + '</a>'
                        + '</td> <td>' + releaseYear + '</td> <td>' + director
                        + '</td> <td>' + rating
                        + '</td> <td> <a onclick= "editDvd(' + dvdId + ')"> edit </a> | <a onclick="deleteDvd(' + dvdId + ')"> delete </a> </td> </tr>');
                });

            } else {
                $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' }).text('No DVD exists'));
            }
        },

        error: function () {
            $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' }).text('Error calling web service'));
        }
    });
}

function validate(input) {

    $('#errorMessages').empty();

    var errorMessage = [];

    input.each(function () {
        ignore: [];
        if (!this.validity.valid) {
            var errorField = (this.id);

            errorMessage.push(errorField + ' ' + this.validationMessage);
        }
    });

    if (errorMessage.length > 0) {
        $.each(errorMessage, function (index, message) {
            $('#errorMessages').append($('<li>').attr({ class: 'list-group-item list-group-item-danger' }).text(message));
        });
        return true;
    } else {
        return false;
    }
}