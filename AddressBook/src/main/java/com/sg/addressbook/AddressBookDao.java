/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class AddressBookDao  {
 
 
 ArrayList<Address> myBook = new ArrayList<>();

 public void addAddress(Address currentAddress){

     myBook.add(currentAddress);
 }
 
 
 public ArrayList<Address> viewAddressByFirst(String search){
    return searchFirstName(search);
     }
 
 
 
 public ArrayList<Address> viewAddressByLast(String search){
   return searchLastName(search);
}  
 
 
 
 public void deleteAddress(String firstName, String lastName){
   ArrayList<Address> found = searchFirstName(firstName);
  
   for (Address e : found){
       if (lastName.equals(e.getLastName())){
           myBook.remove(e);
       }
   }
     
 }
 
 
 
 public void editAddress(String firstName, String lastName, int choice, String change){
    ArrayList<Address> found = searchFirstName(firstName);
  
   for (Address e : found){
       if (lastName.equals(e.getLastName())){
           
         if        (choice == 1){
             e.setFirstName(change);
             
        }  else if (choice == 2){
             e.setLastName(change);
             
        } else if (choice == 3){
             e.setStreet(change);
             
        } else if (choice == 4){
            e.setCity(change);
            
        } else if (choice == 5){
            e.setState(change);
            
        } else if (choice == 6){
            e.setZipcode(change);
            
        } else {
            break;
                        }
       }
    }
}
 
 
 
 public ArrayList<Address> viewAll(){
     return myBook;
 }
 
 
 
  public int viewSize(){
     return myBook.size();
 }
  
  
  
  public void saveToFile() 
          throws Exception {
      PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
      
      for (Address e : myBook){
          out.println(e.getFirstName() + "::" + e.getLastName() + "::" + e.getStreet() + "::" + e.getCity() + "::" + e.getState() + "::" + e.getZipcode());
         
      }
    out.flush();
    out.close();
  }
  
  
  public void readFile()
    throws Exception {
      Scanner sc = new Scanner (
      new BufferedReader ( new FileReader ( "OutFile.txt" )));
      
      while (sc.hasNextLine()) {
          String currentLine = sc.nextLine();
          System.out.println(currentLine);
      }
      
      
  }
 
  
 /*
** re-useable search methods for AddressBookDao methods.
*/

 public ArrayList<Address> searchFirstName(String search){
     ArrayList<Address> found = new ArrayList<>();
     for (Address e : myBook){
         if (search.equals(e.getFirstName())){
             found.add(e);
         }
     }
     return found;
 }
 
 
 
 public ArrayList<Address> searchLastName(String search){
     ArrayList<Address> found = new ArrayList<>();
     for (Address e : myBook){
         if (search.equals(e.getLastName())){
             found.add(e);
         }
     }
     return found;
 }
 

 
 
 
}
