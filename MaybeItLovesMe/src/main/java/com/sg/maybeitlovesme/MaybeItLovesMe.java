/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.maybeitlovesme;

import java.util.Random;

/**
 *
 * @author Lizz
 */
public class MaybeItLovesMe {
    public static void main(String[] args) {
        
    
    Random rGen = new Random();
    
    int petals = rGen.nextInt(89-13) + 1;
        System.out.println("Petals: " + petals);
        
     Boolean x = true;   
        
        do{
          if (x) {
              System.out.println("It loves me!");
              petals--;
              x = false;
          } else {
              System.out.println("It loves me not!");
              petals--;
              x = true;
          }
            
            
        } while (petals > 0);
        if (x) {
            System.out.println("Bummer!");
        }   else {
            System.out.println("Yay!!");
        } 
            
            
            
            
}
}