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
public class FactorizerRe {
       
        Scanner sc = new Scanner(System.in);
        
       private int factorIndex = 0;
       private int sum = 0;
       private int posUserNum;
      private int[] factors;
      
        
        
        
        
        
    public void factorizeNum(int userNum){
      // makes sure to account for negative number
        if (userNum < 0){
             posUserNum = userNum * -1;
        }   else { 
            posUserNum = userNum;
        }
        
  
           //length is positive User Num * 2 to account for negative number factors, this is arbitrary and uses more memory than necessary;
      factors = new int [(posUserNum * 2)];

        //find factorsconsidering negative
     for ( int possibleFactor = 1; possibleFactor <= posUserNum; possibleFactor++){
         if (userNum % possibleFactor == 0){
           factors[factorIndex] = possibleFactor;
           factorIndex++;
         factors[factorIndex] = possibleFactor * -1;
             factorIndex++;
         }
      }

  
     
        //print factors while leaving out the user number and blank spots in array length. To do this, I couldn't print from App since this new Array doesn't really exist- don't know length to create
        for (int i = 0; i< factors.length ; i ++){
            if (!((0 == factors[i]) || factors[i] == userNum || factors[i] == (userNum * -1))){
            System.out.println("factors are " + factors[i]);
            }
        }
    }
        
    public boolean checkPerfect(int userNum){    
        
        boolean perfect = false;
 //boolean is set to false, so can just return as is on else statements. could also say return perfect = false; redundant but clear.
        if (userNum >=0){
        for (int j=0; j<factors.length; j+= 2){
            
         sum  += factors[j];
        }
        
        if(sum/2 == userNum){
             return perfect = true;
        } else {
            return perfect;
        
    } 
        
    } else {
            return perfect; 
                    }
    }
    
    
public boolean checkPrime(int userNum){
    
    boolean prime =  false;
        //find if it's a prime and print, do it for positive and negative
        if (userNum >=0 && sum == 1 + userNum ){
            return prime = true;
            //is it negative? how to print if prime
        } 
        else {
            for (int k=0; k<factors.length; k+= 2){
                sum += factors[k];
              }
            if (sum == (posUserNum + 1)){
                    return prime = true;
            } 
return prime;
    }

}
}
