/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fortimes;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class ForTimes {
    public static void main(String[] args) {
        
        int userNum;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Give me a number to multiply: ");
        userNum = sc.nextInt();
        
        for (int i = 1; i < 16; i ++) {
            System.out.println(i + " * " + userNum + " is: " +  (i * userNum));
            
        }
        
        
    }
}
