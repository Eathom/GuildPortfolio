/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fortimesfor;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class ForTimesFpor {
    
    public static void main(String[] args) {
        int numSelect;
        int score = 0;
        int answer;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Pick a number to multiply: ");
        numSelect = sc.nextInt();
        
        for (int i = 1; i < 16; i++) {
            System.out.println(i + " * " + numSelect + " is: ");
            answer = sc.nextInt();
            
            if (answer == ( i * numSelect)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Sorry, the answer is: " + (i * numSelect));
            }  
        }
        
        System.out.println("Your score is: " + score);
        if(score < 8){
                    System.out.println("Study more.");
                } 
        if (score > 13) {
            System.out.println("Congrats!");
        }
        
    }
}
