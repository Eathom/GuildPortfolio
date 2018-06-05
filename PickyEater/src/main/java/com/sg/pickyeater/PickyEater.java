/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.pickyeater;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class PickyEater {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Is there spinach? (y/n)");
        String hasSpinach = sc.next();
        
        System.out.println("Does it have a funny name? (y/n)");
        String funnyName = sc.next();
        
        System.out.println("How many times has it been fried? (#)");
        int fried = sc.nextInt();
        
        System.out.println("Is it chocolate covered? (y/n)");
        String chocolate = sc.next();
        
        System.out.println("Is it cheese covered? (y/n)");
        String cheese = sc.next();
        
        System.out.println("Is it broccoli? (y/n)");
        String broccoli = sc.next();
        
        System.out.println("How many pats of butter? (#)");
        int butter = sc.nextInt();
        
        if (hasSpinach.equals("y") || funnyName.equals("y") ) {
            System.out.println("There's no way that'll get eaten");
        }
        //test 4 > fried > 2
        else if ( chocolate.equals("y") && (4 > fried && fried > 2)) {
            System.out.println("Oh, it's like a deep fried snickers! That'll be a hit!");
        }
        else if (fried == 2 && cheese.equals("y")) {
            System.out.println("Fried cheesy doodles with get eaten");
    }
        else if (broccoli.equals("y") && butter > 6 && cheese.equals("y")) {
            System.out.println("As long as green is hidden by butter and cheese");
        }
        //else also works
        
        else if (broccoli.equals("y")) {
            System.out.println("Green stuff may as well go in trash");
        }
        
    }
}
