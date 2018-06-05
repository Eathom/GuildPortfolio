/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class View implements UserIO {
 Scanner sc = new Scanner(System.in);
 
    @Override
    public String getStringInput(String prompt){
        
        System.out.println(prompt);
        String input = sc.nextLine();
        return input;
    }

    @Override
    public int getIntInput(String prompt){
        System.out.println(prompt);
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }
    
   @Override
   public void showAddress(ArrayList<Address> current){
       
      for (Address e : current) {
      System.out.println(e.getFirstName());
       System.out.println(e.getLastName());
       System.out.println(e.getStreet());
       System.out.println(e.getCity() + ", " + e.getState() + e.getZipcode() + "\n");
       
   }
}
   
@Override
public void showNum(int size){
    System.out.println(size);
}
}