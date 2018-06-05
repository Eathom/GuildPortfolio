/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lovesme;

/**
 *
 * @author Lizz
 */
public class LovesMe {
    public static void main(String[] args) {
        int petals = 10;
        
        while (petals > 0) {
            
        if(petals % 2 == 0) {
            System.out.println("It loves me not!");
        } else if (petals % 2 == 1) {
            System.out.println("It loves me");
        }
            petals--;
    }
        System.out.println("I knew it, it loves me!");
}
}
//did a while loop since petals is set for above 0 and will meet condition.
// only counts down to 1 petal , so modulus is a 1 always.