/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.twoforsten;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class TwoForsTen {
    public static void main(String[] args) {
        
    
    Scanner sc = new Scanner(System.in);
    int year;
    
        System.out.println("Choose a year to count back from:");
        year = sc.nextInt();
        
        for (int i = 0; i <= 10; i++){
            
            System.out.println(i + " years ago would be " + (year - i));
        }
    
        System.out.println("Counting backwards a different way");
        
        for(int i = year; i >= year - 20; i--) {
            System.out.println((year - i) + "years ago would be " + i );
        }
    }
    
}
