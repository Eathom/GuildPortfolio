/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tradfizzbuzz;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class TradFizzBuzz {
    public static void main(String[] args) {
        
        int count = 0;
        int fizzBuzzStop;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many units of fizzing and buzzing do you need "
                + "in your life?");
        fizzBuzzStop = sc.nextInt();
        
        for (int i = 0; count < fizzBuzzStop; i++){
            
            if (i % 3 == 0 && i % 5 == 0 && i != 0){
                System.out.println("fizz buzz");
                count++;
            } else if (i % 3 == 0 && i != 0){
                System.out.println("fizz");
                count++;
            }else if (i %5 ==0 && i !=0) {
                System.out.println("buzz");
                count++;
            }else {
                System.out.println(i);
            }
           
           
        }
        System.out.println("TRADITION!!");
    }
}
