/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dto.Address;
import java.util.List;

/**
 *
 * @author Lizz
 */
public class View {
   private UserIO io;
    //Constuctor to loosely couple to io; wired together in App
    public View(UserIO io){
        this.io = io;
    }
    //will handle the menu, what the user sees
    public int printMenuGetSelectn(){
        io.print("WELCOME TO MY ADDRESS BOOK \n <3<3<3 Main Menu <3<3<3");
        
        io.print("1. Add an address");
        io.print("2. Remove an address");
        io.print("3. View number of address entries");
        io.print("4. View an address");
        io.print("5. View all addresses");
        io.print("6. Edit an address");
        io.print("7. Exit address book program");
        
       return io.getInt("Select # from above choices", 1, 7);
    }
 
    
    // will use io to get specific messages to user, will also return user input to controller
    
    public Address getAddr(){
       Address newAddr = new Address();
        newAddr.setfName(io.getString("Enter first name."));
        newAddr.setlName(io.getString("Enter last name."));
        newAddr.setAddr(io.getString("Enter address."));
        return newAddr;
    }
    
    
    public String getInfo(String prompt){
       
        String info = io.getString(prompt);
        return info;
    }
    
    public void showCount(int num){
        io.print("Number of entries: " + num);
        hitCont();
    }
    
    public void showAddr(Address show){
        if (show.getlName() != null){
        io.print(show.getfName() + " " + show.getlName() + " " + show.getAddr());
        } else {
            io.print("Person not found.");
        }
        hitCont();
    }
    
    public void showAll(List<Address> book){
        for (Address current : book){
          io.print(current.getfName() + " " + current.getlName() + " " + current.getAddr());  
        }
        hitCont();
    }
    

    
    
    //
    //DISPLAY messages
    //
    public String hitCont(){
        return io.getString("Press enter to continue");
    }
    
    
    public void notFound(){
        io.print("Not found, unsuccessful.");
    }
    
    public void exitMsg(){
        io.print("0.o.0.o Good bye!! 0.o.0.0.o");
    }
    
    public void errorMsg(String errorMsg){
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    //
    // add addr banners
    //
    
    public void dispAdd(){
        io.print("ADD AN ADDRESS");
    }
    
    public void dispAddSuc(){
        io.print("~~~Address added~~~~");
        hitCont();
    }
    
    //
    // remove addr banners
    //
    public void dispRemove(){
        io.print("REMOVE AN ADDRESS");
    }
    
    public void dispRemoveSuc(){
        io.print("~~~ Address removed~~~");
        hitCont();
    }
    
    //
    // edit banner
    //

    public void dispEditSucs(){
        io.print("~~~Address edited ~~~~");
    }
    
    public void dispEditFail(){
        io.print("Could not edit, person not found");
    }
  
}
