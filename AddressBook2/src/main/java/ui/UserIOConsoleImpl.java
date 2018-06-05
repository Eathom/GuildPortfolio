/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class UserIOConsoleImpl implements UserIO {
    Scanner sc = new Scanner(System.in);
    //impl methods for interacting with user, print and read various types of data

@Override    
public void print(String msg){
    System.out.println(msg);
}    


@Override 
public String getString(String prompt){
    System.out.println(prompt);
     String strInput = sc.nextLine();
     return strInput;
}

@Override 
public int getInt(String prompt){
    System.out.println(prompt);
    String strInput = sc.nextLine();
    int input = Integer.parseInt(strInput);
    return input;
}

@Override 
public int getInt(String prompt, int min, int max){
    int input;
    
   do{
       System.out.println(prompt);
      String strInput = sc.nextLine();
     input = Integer.parseInt(strInput);
   } while ( input < min || input > max);
   
   return input;
}
}
