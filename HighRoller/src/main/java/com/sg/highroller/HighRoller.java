/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.highroller;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class HighRoller {
    public static void main(String[] args) {
        
        Random diceRoller = new Random();
        Scanner sc = new Scanner(System.in);
        
        
       
       
        System.out.println("Please choose how many sided dice you'd like to use");
        int diceSides = sc.nextInt();
        
         int rollResult = diceRoller.nextInt(diceSides) + 1;
                
        System.out.println("\n Time to roll the dice.");
        System.out.println("I rolled a " + rollResult + ".");
        
        if (rollResult == 1) {
            System.out.println("You rolled a crit failure! Ouch");
        }
         if (rollResult == diceSides) {
            System.out.println("You rolled a critical! Nice job!");
        }
        //coud use else-if but a 1 sided dice doesn't exist so both will not print.
        
        
    }
  
}
