/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizer;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class Factorizer {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int factorIndex = 0;
        int sum = 0;
        int posUserNum;
        int possibleFactor;
        
  System.out.println("Please choose a number to factorize: ");
        int userNum = sc.nextInt();
        if (userNum < 0){
            posUserNum = userNum * -1;
        }   else { 
            posUserNum = userNum;
        }
   //length is positive User Num * 2 to account for negative number factors, this is arbitrary and uses more memory than necessary;
      int[] factors = new int [(posUserNum * 2)];

        //find factorsconsidering negative
     for ( possibleFactor = 1; possibleFactor <= posUserNum; possibleFactor++){
         if (userNum % possibleFactor == 0){
           factors[factorIndex] = possibleFactor;
           factorIndex++;
         factors[factorIndex] = possibleFactor * -1;
             factorIndex++;
         }
             
     }
  
     
        //print factors while leaving out the user number and blank spots in array length.
        for (int i = 0; i< factors.length ; i ++){
            if (!((0 == factors[i]) || factors[i] == userNum || factors[i] == (userNum * -1))){
            System.out.println("factors are " + factors[i]);
            }
        }
        
        //perfect number and print, disclude negatives (negative number can't be perfect)
        if (userNum >=0){
        for (int j=0; j<factors.length; j+= 2){
            
         sum  += factors[j];
        }
        
        if(sum/2 == userNum){
            System.out.println("Perfect number!");
        }
      } 
    
        //find if it's a prime and print, do it for positive and negative
        if (userNum >=0 && sum == 1 + userNum ){
            System.out.println("It's a prime!");
            //is it negative? how to print if prime
        } 
        if (userNum <0){
            for (int k=0; k<factors.length; k+= 2){
                sum += factors[k];
              }
            if (sum == (posUserNum + 1)){
                    System.out.println("It's a prime!");
            }

}
    }
}
