/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizerre;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class App {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FactorizerRe myFact = new FactorizerRe();
        
        System.out.println("Choose a number to factorize:");
        int userNum = sc.nextInt();
        
        myFact.factorizeNum(userNum);
        
         if (myFact.checkPerfect(userNum)) {
             System.out.println("It's a perfect number!");
      }
       
         if (myFact.checkPrime(userNum)) {
             System.out.println("It's a prime number!");
         }
         
         
          
         
        
        
        
    }
}
