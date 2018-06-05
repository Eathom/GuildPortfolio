/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.input;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class Input {
    public static void main(String[] args) {

        Random rGen = new Random();
        
     int answer = rGen.nextInt(20) + 1;
     int guess;
    
     
     Scanner sc = new Scanner (System.in);
     
     while (true) {
         System.out.println("Guess an answer between 1 and 20");
         guess = sc.nextInt();
         
         if (guess == answer) {
             // next line may need to go at end
         
             //infinite loop, only way to break out is to reach end
             break;
         }
          if (guess < 1 || guess > 20 ) {
             System.out.println("Out of bounds");
             continue;
         }
          if (answer > guess) {
             System.out.println("Guess higher");
             continue;
         }
         
             System.out.println("Guess lower");
     }
         
             System.out.println("Victory!");
     }
}
        
         
       
        


