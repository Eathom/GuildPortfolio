/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lazyteenager;

import java.util.Random;

/**
 *
 * @author Lizz
 */
public class LazyTeenager {
    public static void main(String[] args) {
        Random rGen = new Random();
        


// this version I am decreasing the pool of possible #'s by 5 to increase the chance of guessing 1. I dont think this amounts to an increase of 5%.
       /* 
        int willCleanRoom = 1;
        int teenagerResponse;
        int chance = 95;
        int timesTold = 0;
        
        do {
            System.out.println("Clean your room!");
            teenagerResponse = rGen.nextInt(chance) + 1;
            System.out.println("chance: " + chance + "response: " + teenagerResponse);
            chance -= 5;
            timesTold++;
            
            if (teenagerResponse == willCleanRoom) {
                System.out.println("Fine, I'll clean my room!");
               
            }
            if (timesTold == 15) {
                System.out.println("You're grounded!");
                break;
            }
            
        } while (teenagerResponse != willCleanRoom);
      */
       
       
        // this version broadens the possible number that leads to cleaning.
        
        Boolean willCleanRoom = false;
        int teenagerResponse;
        int timesTold = 0;
        int chance = 5;
        
        do {
            System.out.println("Clean your room!");
            teenagerResponse = rGen.nextInt(100)+1;
            System.out.println("chance: " + chance + " Response: " + teenagerResponse);
            
            
            if ( teenagerResponse >= 1 && teenagerResponse <= chance){
                willCleanRoom = true;
                System.out.println("Fine, I'll clean my room!");
            }
            
            if (timesTold == 15) {
                System.out.println("You're grounded!");
                break;
            }
           timesTold++;
            chance +=5; 
            
        }while (!willCleanRoom);
        
       
    }
}
