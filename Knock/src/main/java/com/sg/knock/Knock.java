/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.knock;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class Knock {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Knock, knock! Guess who!");
        String nameGuess = sc.nextLine();
        
       // if (nameGuess == "Marty McFly") == only compares reference, not content
       if (nameGuess.equalsIgnoreCase("Marty McFly"))    {
       System.out.println("Correct!");
            System.out.println(".. from the future!");
        } else {
            System.out.println("Do I look like " + nameGuess);
        }
    }
}
