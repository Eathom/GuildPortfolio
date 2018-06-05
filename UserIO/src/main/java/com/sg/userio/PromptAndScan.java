/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.userio;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class PromptAndScan implements UserIO {
    
       Scanner sc = new Scanner(System.in);
       
       @Override
    public void print(String message){
        System.out.println(message);
    }
    
       @Override
    public double readDouble(String prompt){
        System.out.println(prompt);
        
        String input = sc.nextLine();
        return Double.parseDouble(input);
    }

       @Override
    public double readDouble(String prompt, double min, double max){
        String strInput;
        double input;
        
        do {
            System.out.println(prompt);
             strInput = sc.nextLine();
             input = Double.parseDouble(strInput);
            
        } while (input < min || input > max );
        
        return input;
    } 

    
       @Override
    public float readFloat(String prompt){
        System.out.println(prompt);
        
        String input = sc.nextLine();
        return Float.parseFloat(input);
    }

       @Override
    public float readFloat(String prompt, float min, float max){
        String strInput;
        float input;
        
        do{
            System.out.println(prompt);
            strInput = sc.nextLine();
           input = Float.parseFloat(strInput);
        } while (input < min || input > max);
        
        return input;
    }

       @Override
    public int readInt(String prompt){
        System.out.println(prompt);
        String input = sc.nextLine();
        return Integer.parseInt(input);
   }

       @Override
    public int readInt(String prompt, int min, int max){
        String strInput;
        int input;
        
        do{
            System.out.println(prompt);
            strInput = sc.nextLine();
            input = Integer.parseInt(strInput);
        } while (input < min || input > max);
        
        return input;
    }

       @Override
    public long readLong(String prompt){
        System.out.println(prompt);
        String input = sc.nextLine();
        return Long.parseLong(input);
    }

       @Override
    public long readLong(String prompt, long min, long max){
        String strInput;
        long input;
        
        do {
            System.out.println(prompt);
            strInput = sc.nextLine();
            input = Long.parseLong(strInput);
        } while (input < min || input > max);
        return input;
        
    }

       @Override
    public String readString(String prompt){
        System.out.println(prompt);
        return sc.nextLine();
    }
    
    
    
}
