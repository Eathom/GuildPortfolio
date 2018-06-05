/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.staypositive;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class StayPositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Pick a number ");
        int num = sc.nextInt();
        
        int timesPrinted = 0;
        
    while (num >= 0) {
        System.out.print(num + " ");
        num--;
        timesPrinted++;
        //when timesPrinted gets to 10, 20, 30 the remainder is 0. So every 10 prints, it will do a \n newline.
        if (timesPrinted % 10 == 0){
            System.out.print("\n");
            
        }
}
}
}