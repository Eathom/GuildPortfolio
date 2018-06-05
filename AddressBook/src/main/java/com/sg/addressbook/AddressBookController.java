/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook;

/**
 *
 * @author Lizz
 */
public class AddressBookController {
  private AddressBookDao myBookDao = new AddressBookDao();
   
  private  View myView = new View();
  private int choice;  
    
    
    public void execute() throws Exception {
    
    do {
       choice = myView.getIntInput("Address book menu: 1. add  2. view  3. delete \n 4. edit 5. list all 6. show number of entries \n 7. save 8. read file 9. exit");
               
        switch (choice){
        
        case 1 : 
            Address currentAddress = new Address();  
             currentAddress.setFirstName(myView.getStringInput("Enter first name"));
             currentAddress.setLastName(myView.getStringInput("Enter last name"));
            currentAddress.setStreet(myView.getStringInput("Enter street address"));
            currentAddress.setCity(myView.getStringInput("Enter city"));
            currentAddress.setState(myView.getStringInput("Enter state"));
            currentAddress.setZipcode(myView.getStringInput("Enter zipcode"));
     
            myBookDao.addAddress(currentAddress);
            break;
            
        case 2:
            int searchChoice = myView.getIntInput("Search by: 1. first name 2. last name");
            
            if (searchChoice == 1){
            myView.showAddress(myBookDao.viewAddressByFirst(myView.getStringInput("Search by first name")));
            
            } else if (searchChoice == 2){
                myView.showAddress(myBookDao.viewAddressByLast(myView.getStringInput("Search by last name")));
                 }
            break;
            
        case 3:
           myBookDao.deleteAddress(myView.getStringInput("Enter first name"), myView.getStringInput("Enter last name"));
           break;
            
        case 4:
            myBookDao.editAddress(myView.getStringInput("Enter first name"), myView.getStringInput("Enter last name"), myView.getIntInput("Edit: 1. first name 2. last name 3. street 4. city 5. state 6. zip"), myView.getStringInput("What are you changing the field to?"));
            
            break;
        case 5:
            myView.showAddress(myBookDao.viewAll());
            
            break;
            
        case 6:
            myView.showNum(myBookDao.viewSize());
            break;
            
        case 7:
            myBookDao.saveToFile();
            break;
            
        case 8:
            myBookDao.readFile();
            break;
            
        case 9:
             System.out.println("Have a great day");
            break;
        default:
            System.out.println("Invalid answer");
    } 
      
    
        
     
    } while (!(choice == 9));
    
}
}
