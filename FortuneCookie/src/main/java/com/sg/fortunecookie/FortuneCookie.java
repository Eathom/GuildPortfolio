/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fortunecookie;

import java.util.Random;

/**
 *
 * @author Lizz
 */
public class FortuneCookie {
    public static void main(String[] args) {
        
    
    Random rGen = new Random();
  
  
   int fortune = rGen.nextInt(10) + 1; 
    System.out.print("Your fortune is: " ); 
    // did .print vs .println to not \n newline - format matches example.
    if (fortune == 1) {
        System.out.println("Those aren’t the droids you’re looking for.");
    }
    else if (fortune == 2) {
        System.out.println("Never go in against a Sicilian when death is on the line!");
    } else if (fortune == 3) {
        System.out.println("Goonies never say die.");
    } else if (fortune == 4) {
        System.out.println("With great power there must also come — great responsibility.");
    } else if (fortune == 5) {
        System.out.println("Never argue with the data.");
    } else if (fortune == 6) {
        System.out.println("Try not. Do, or do not. There is no try.");
    } else if (fortune == 7) {
        System.out.println("You are a leaf on the wind, watch how you soar.");
    } else if (fortune == 8) {
        System.out.println("Do absolutely nothing, and it will be everything that you thought it could be.");
    } else if (fortune == 9) {
        System.out.println("Kneel before Zod.");
    } else if (fortune == 10) {
        System.out.println("Make it so.");
    }
    
   
    
  } 
   
    }

