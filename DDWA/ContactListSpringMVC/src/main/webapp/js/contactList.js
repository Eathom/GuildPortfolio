/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    
    $('#search-button').click(function(){
        
        $.ajax({
            type: 'POST',
            url: '/search/contacts',
            data: JASON.stringify({
                firstName: $('#search-first-name').val(),
                lastName: $('#search-last-name').val(),
                company: $('#search-company').val(),
                phone: $('#search-phone').val(),
                email: $('#search-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function(data){
                $('#errorMessages').empty();
                fillContactTable(data);
            },
            error: function(){
                $('#errorMessages').append($('<li>')
                        .attr({class: 'list-group-item list-group-item-danger'})
                            .text('Error calling web service'));
            }
        });
    });
});

function fillContactTable(data){
    clearContactTable();
    
    var contentRows = $('#contentRows');
    
    $.each(data, function(index, contact){
        var name = contact.firstName + ' ' + contact.lastName;
         var company = contact.company;
        var phone = contact.phone;
        var email = contact.email;
        
        var row = '<tr>';
        row += '<td>' + name + '</td>';
         row += '<td>' + company + '</td>';
        row += '<td>' + phone + '</td>';
        row += '<td>' + email + '</td>';
        row += '</tr>';
        
        ContentRows.append(row);
    });
}

function clearContactTable(){
    $('#contentRows').empty();
}