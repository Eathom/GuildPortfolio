/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.yourlife;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class YourLife {
    public static void main(String[] args) {
        int year;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What year were youu born");
        year = sc.nextInt();
        
        if (year < 2005) {
        System.out.println("Up came out half a decade ago");
    }
         if (year <1995) {
                System.out.println("first Harry P came  out 15 years ago");
                }
         if (year < 1985) {
                System.out.println("Space Jam out out decade before last");
                }
    } if{year < 1975) {
            System.out.println("Jurassic park closer to lunar landing than today");
    }
     if (year < 1965) {
            System.out.println("Mast out");
            }
    else {
            System.out.println("you're too young to play");
            }
}
    
}
//every if thats true prints out a line, vs else if.