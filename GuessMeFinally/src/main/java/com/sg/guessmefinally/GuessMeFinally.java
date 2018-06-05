/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessmefinally;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class GuessMeFinally {
    public static void main(String[] args) {
        
    
    Random rGen = new Random();
    Scanner sc = new Scanner(System.in);
    
    int answer = rGen.nextInt(201) - 100 ;
    int guess;
    
      do{
          System.out.println("Guess my number between -100 and 100.");
          guess = sc.nextInt();
        System.out.println("Your guess: " + guess);
          System.out.println("\n");
        if (guess > answer){
            System.out.println("Too high, try again!");
        } else if (guess < answer) {
            System.out.println("Too low, try again!");
        } else if (guess == answer) {
            System.out.println("Victory! You got it!");
        } else {
            System.out.println("Invalid answer, please enter a number.");
        }
        
        
        } while (guess != answer);
      
        
        System.out.println("Thanks for playing.");
        
        
        
    }
}
