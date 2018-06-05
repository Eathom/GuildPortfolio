/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class UserIOConsoleImpl implements UserIO {

    Scanner sc = new Scanner(System.in);
    
     @Override
    public void print(String msg) {
         System.out.println(msg);
    }
    

    @Override
    public String getString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    @Override
    public int getInt(String prompt) {
        System.out.println(prompt);
        String strInput = sc.nextLine();
        return Integer.parseInt(strInput);
        
    }

    @Override
    public int getInt(String prompt, int min, int max) {
        String strInput;
        int input;
        
        do {
        System.out.println(prompt);
        strInput = sc.nextLine();
        input = Integer.parseInt(strInput);
    } while (input < min || input > max);

   return input;
}

    @Override
    public LocalDate getLD(String prompt) {
        System.out.println(prompt);
        String strInput = sc.nextLine();
        LocalDate releaseLD = LocalDate.parse(strInput, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        
        return releaseLD;
    }
    
    
}
