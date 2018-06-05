/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.doggenetics2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class DogGenetics2 {
    public static void main(String[] args) {
        
    Random rGen = new Random();    
    int[] dogs = {0, 0, 0, 0, 0};
    int numRemain = 95;    
        
        
     getName("What's your dog's name?");

     for (int i = 0; i < dogs.length - 1; i++){
         if (numRemain > 0){
             dogs[i] += rGen.nextInt(numRemain) + 1;
             numRemain -= dogs[i] ;
         }
     }
     if (numRemain> 0){
      dogs[4] += numRemain;  
     }
     
     for (int j = 0; j< dogs.length; j++){
         dogs[j] +=1;
     }
      
        System.out.println(dogs[0] + "% Poodle");
        System.out.println(dogs[1] + "% Lab");
        System.out.println(dogs[2] + "% Dachshund");
        System.out.println(dogs[3] + "% Rat Terrier");
        System.out.println(dogs[4] + "% Great Dane");
        
        System.out.println("\n \n \n \n \n total % checker: " + (dogs[0] + dogs[1] + dogs[2] + dogs[3] + dogs[4]));
        
            }
    public static void getName(String prompt){
         Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String name = sc.nextLine();
        System.out.println("I have some highly accurate DNA results on " + name + ". \n \n " + name + " is: \n" );
    }
   
    
}
