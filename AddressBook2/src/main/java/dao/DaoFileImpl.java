/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class DaoFileImpl implements Dao {
    
    //hold the data
    List<Address> book = new ArrayList<>();
    
    //data marshalling variables
    public static final String ADDRESS_FILE = "addrBook.txt";
    public static final String DELIMITER = "::";
    
    
    //impl methods to work with data
 
    
   @Override 
   public void add(Address newAddr)
   throws DaoException {
    book.add(newAddr);
       writeBook();
   }
   
   

    @Override 
    public boolean remove(String lName)
    throws DaoException {
    boolean found = false;
    int index = -1;
    
    for (Address current : book){    
    if (lName.equals(current.getlName())){
         index = book.indexOf(current);
        found = true;
    }
    }
    if (found){
    book.remove(index);
    }
    writeBook();
    return found;
    }
    
    
    
 @Override 
    public int getCount()
    throws DaoException {
        return book.size();
    }
    
    
    
 @Override 
    public Address viewAddr(String lName)
    throws DaoException {
        loadBook();
        Address show = new Address();
        
        for (Address current : book){
            if (lName.equals(current.getlName())) {
                 show = current;
            }
        }
     return show;   
    }
    
 @Override 
    public List<Address> viewAll()
    throws DaoException {
        loadBook();
        return book;
    }
    
    @Override
    public boolean edit(String lName, String newAddr)
    throws DaoException {
        boolean found = false;
        int index = -1;
        
        for (Address current : book){
            if (lName.equals(current.getlName())) {
                found = true;  
                index = book.indexOf(current);
            }
        }
        if (found){
            book.get(index).setAddr(newAddr);
        }
        writeBook();
        return found;
           
    }
    
    
    
    public void loadBook() throws DaoException {
        Scanner sc;
        
        try {
            sc = new Scanner(
            new BufferedReader(
            new FileReader(ADDRESS_FILE)));
            
            }catch (FileNotFoundException e){
                throw new DaoException(
                "Could not load address data into memory.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        
        while (sc.hasNext()){
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
          // create a new address object  
           Address current = new Address();
          
           //add token array to student fields
       current.setfName(currentTokens[0]);
       current.setlName(currentTokens[1]);
       current.setAddr(currentTokens[2]);
           
       //add current address object to book
        book.add(current);
        }
        
        //after looping through each line of file, close the scanner for reading
        
        sc.close();
            
        }
    
    
    public void writeBook() throws DaoException {
        
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(ADDRESS_FILE));
            //net beans' lightbulb will say which exception will be thrown
        } catch (IOException e) {
            //translate the exception thrown into Dao to prevent "leaky abstraction"
            throw new DaoException( "Could not save data to file", e);
        }
        for (Address current : book) {
            out.println(current.getfName() + DELIMITER 
                           + current.getlName() + DELIMITER
                        + current.getAddr() + DELIMITER);
            
            //in each loop, may need to flush (force print)
            out.flush();
        }
        //close printWriter to give resource back
        out.close();
        }
    }
    
    

