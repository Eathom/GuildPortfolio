/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 
 function search() {
 
 $('#contentRows').empty();
 var haveErrors = validate($('#search-dvd-form').find('input, select'));
 if (haveErrors) {
 return false;
 }

 
 
 $.ajax({
 type: 'POST',
 url: 'search/dvds/',
 data: JSON.stringify({
     category: $('#search-category').val(),
     term: $('#search-term').val(),
     
 }),
 headers: {
     'Accept': 'application/json',
     'Content-Type': 'application/json'
 },
 'dataType': 'json',
 
 success: function (data) {
 $('#errorMessages').empty();
 fillContactTable(data);
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
 
 function fillContactTable(data){
     clearContactTable();
     
     var contentRows = $('#contentRows');
     
     $.each(data, function(index, dvd){
         var title = dvd.title;
         var rlsDate = dvd.rlsDate;
         var rating = dvd.rating;
         var director = dvd.director;
         
         var row = '<tr>';
         row += '<td>' + title + '</td>';
         row += '<td>' + rating + '</td>';
         row += '<td>' + rlsDate + '</td>';
         row += '<td>' + director + '</td>';
         row += '</tr>';
         
         contentRows.append(row);
                
     });
 }
 
 function clearContactTable(){
     $('#contentRows').empty();
 }