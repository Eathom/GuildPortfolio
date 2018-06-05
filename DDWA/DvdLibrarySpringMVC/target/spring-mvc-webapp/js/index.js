/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: 'dvds',
        success: function (dvdArray) {
            
            $('#contentRows').empty();
            
            $('#errorMessages').empty();
            if (dvdArray.length > 0) {

                $.each(dvdArray, function (index, dvd) {

                    var id = dvd.dvdId;
                    var title = dvd.title;
                   
                    var rating = dvd.rating;
                   
                    $('#contentRows').append(
                            '<tr><td><a href="showDetails?dvdId=' + id + '">' + title + '</a></td><td>' + rating + '</td>' +
                            '<td><a href="displayEditPage?dvdId=' + id + '"> Edit</a></td><td><a href="deleteDvd?dvdId=' + id + '">Delete</a></td></tr>');
                });
            } else {
                $('#errorMessages').append($('<li>')
                        .attr({class: 'list-group-item list-group-item-danger'})
                        .text('No Dvd\'s in memory'));
            }
        },
        error: function () {
            $('#errorMessages').append($('<li>')
                    .attr({class: 'list-group-item list-group-item-danger'})
                    .text('Problem calling web service'));
        }
    });

});


 
