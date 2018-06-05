/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.trivia;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class Trivia {
    public static void main(String[] args) {
        
        int score = 0;
        
        int ans1 = 1;
        int guess1;
        
         int ans2 = 3;
        int guess2;
        
         int ans3 = 2;
        int guess3;
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("It's TRIVIA TIME!!!!!");
        System.out.println("");
        
        System.out.println("First Question");
        System.out.println("What color are roses?");
        System.out.println("1) all          2) red          3) blue         4) yellow");
        guess1 = sc.nextInt();
        System.out.println("Your answer: " + guess1 + "\n");
        
        System.out.println("Second Question");
        System.out.println("What color are dogs?");
        System.out.println("1) all          2) red          3) doggie colored         4) yellow");
        guess2 = sc.nextInt();
        System.out.println("Your answer: " + guess2 + "\n");
        
        System.out.println("Third Question");
        System.out.println("What color are banans?");
        System.out.println("1) all          2) yellow          3) doggie colored         4) black");
        guess3 = sc.nextInt();
        System.out.println("Your answer: " + guess3 + "\n");
        
        if (ans1 == guess1) {
            score++;
        }
        if (ans2 == guess2) {
            score++;
        }
        if (ans3 == guess3) {
            score++;
        }
        
        System.out.println("Nice job! You got " + score + " correct!");
        
        if (score == 3) {
            System.out.println("Whoohoo, perfect job!");
        } 
            else if (score == 0) {
                    System.out.println("Big loss! Zero right.");
                    } 
        
    }
    
}
