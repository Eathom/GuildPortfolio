/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplesort;

/**
 *Combine the following 2 arrays into one large array that has all the numbers sorted in increasing order, then print them out!
 * @author Lizz
 */
public class SimpleSort {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};
        
        int[] wholeNumbers = new int[24];
         
      

    int temp;
    /* first way    
        
        int wholeIndex = 12;
 for (int i =0; i < firstHalf.length; i++){
     wholeNumbers[i] = firstHalf[i];
 }       
        for (int j = 0; j < secondHalf.length; j++){
           
                    
            wholeNumbers[wholeIndex] = secondHalf[j];
            wholeIndex++;
        }

*/
      System.arraycopy(firstHalf, 0, wholeNumbers, 0, firstHalf.length);
      System.arraycopy(secondHalf, 0, wholeNumbers, firstHalf.length, secondHalf.length);
      
      for (int l = 0; l<wholeNumbers.length; l++){
     System.out.println(wholeNumbers[l] + " " + l);
     
      }
 for (int k = 0; k < wholeNumbers.length; k++){
     for (int j = 0; j<wholeNumbers.length-1; j++)
     if (wholeNumbers[j] > wholeNumbers[j+ 1]){
         temp = wholeNumbers[j];
         wholeNumbers[j]= wholeNumbers[j+1];
         wholeNumbers[j+1] = temp;    
     }
 }
        
        
        
 //PRINT
 for (int m = 0; m<wholeNumbers.length; m++){
     System.out.println(wholeNumbers[m] + " " + m);
 }
        
        
    }
}
