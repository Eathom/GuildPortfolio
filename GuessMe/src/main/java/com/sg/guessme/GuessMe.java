/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessme;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class GuessMe {
    public static void main(String[] args) {
        int num = 87;
        int guess;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Guess a number");
        guess = sc.nextInt();
        
        if (guess == num) {
            System.out.println("Victory!");
        }
        else if (guess < num) {
            System.out.println("Too low, I chose " + num);
        }
        else {
            System.out.println("Too high, I chose " + num);
        }
      
        
    }
}
