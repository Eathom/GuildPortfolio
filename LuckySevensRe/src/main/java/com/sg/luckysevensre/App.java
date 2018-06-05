/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensre;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many dollars do you have?");
        int userInput = sc.nextInt();
 
 
 
        LuckySevensRe myLuck = new LuckySevensRe();
        
        
        myLuck.playGame(userInput);
        
        
        
    }
}
