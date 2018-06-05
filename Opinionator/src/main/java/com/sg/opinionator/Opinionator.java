/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.opinionator;

import java.util.Random;

/**
 *
 * @author Lizz
 */
public class Opinionator {
    public static void main(String[] args) {
        Random rGen = new Random();
        
        System.out.println("I can't decide what my favorite animal is.");
        System.out.println("I'll let random decide for me!");
        
        int x = rGen.nextInt(6);
        // change 5 to 6 to include 5 (0 is included, 6 is exclusive)
        System.out.println("The number chosen is: " + x);
        
        System.out.println("\n My favorite animals are:");
        if (x == 0) {
            System.out.println("Llamas");
        } else if (x == 1) {
            System.out.println("Dodos");
        } else if (x == 2) {
            System.out.println("Wooly Mammoths");
        } else if (x == 3) {
            System.out.println("Sharks");
        } else if (x == 4) {
            System.out.println("Cockatoos");
        } else if (x == 5) {
            System.out.println("Mole-rats");
        }
        
        System.out.println("Thanks, Random, you're the best.");
        
        
        
    }
}
