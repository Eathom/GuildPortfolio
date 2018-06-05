/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessmemore;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class GuessMeMore {
    public static void main(String[] args) {
        
        Random rGen = new Random();
        Scanner sc = new Scanner(System.in);
        
        int rNum = rGen.nextInt(101);
        Boolean posOrNeg = rGen.nextBoolean();
        int answer;
        int guess;
        String strGuess;
        
        if (posOrNeg == true) {
            answer = rNum;
        } else {
            answer = rNum * -1;
        }
        /*
        
        while(true) {
        System.out.println("Guess a number between -100 and 100.");
        strGuess = sc.nextLine();
        guess = Integer.parseInt(strGuess);
        
        System.out.println("Your guess: " + guess + "\n");
        
        if (guess == answer) {
            System.out.println("Wow, nice guess! That was it!");
            break;
        } else if (guess > answer) {
            System.out.println("Guess a lower number!");
            continue;
        } else {
            System.out.println("Guess a higher number!");
            continue;
        }
        */
        
        do {
            System.out.println("Guess a number between -100 and 100");
            strGuess = sc.nextLine();
            guess = Integer.parseInt(strGuess);
            System.out.println("Your guess: " + guess + "\n");
            
            if (guess > answer) {
                System.out.println("Guess a lower number!");
            } else if (guess < answer ){
                System.out.println("Guess a higher number!");
            }
            
        }
        while (guess != answer);
        
            System.out.println("Wow, nice guess! That was it!");
        
     
            
       
        
        }
        
        
    }
    

