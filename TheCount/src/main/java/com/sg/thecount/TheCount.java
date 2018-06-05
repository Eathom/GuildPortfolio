/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thecount;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class TheCount {
    public static void main(String[] args) {
        
        int timesPrinted = 0;
        Scanner sc = new Scanner(System.in);
        
        int start;
        int end;
        int increment;
        
        System.out.print("Start at: ");
        start = sc.nextInt();
        System.out.print("Stop at: ");
        end = sc.nextInt();
        System.out.println("Count by: ");
        increment = sc.nextInt();
        
        for (int i = start; i <= end; i += increment){
            System.out.print(i + " ");
            timesPrinted++;
            if (timesPrinted % 3 == 0){
                System.out.print("Ah ah ah! \n");
                        
            }
        }
        
        
        
    }
   
}
