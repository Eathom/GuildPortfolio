/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.coinflipper;

import java.util.Random;

/**
 *
 * @author Lizz
 */
public class CoinFlipper {
    public static void main(String[] args) {
        
        Random rGen = new Random();
        
        String coinSide;
        Boolean toss = rGen.nextBoolean();
        
        if (toss == true) {
            coinSide = "Tails";
        }
        else {
            coinSide = "Heads";
        }
        
        
        System.out.println("Ready, Set, Flip");
        System.out.println("You got " + coinSide + "!");
        
        
        
    }
}
