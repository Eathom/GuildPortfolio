/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.summativesums;

/**
 *
 * @author Lizz
 */
public class SummativeSums {
    public static void main(String[] args) {
    int[][] nums = {{ 1, 1, 90, -33, -55, 67, -16, 28, -55, 15 },      
                    {2, 999, -60, -77, 14, 160, 301},
                    {3, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
        140, 150, 160, 170, 180, 190, 200, -99 }};
        
        

    
    //print out 1st number in each array that I have entered.
    for (int j = 0; j < nums.length; j++){
        System.out.println("#" + (j+1) + " Array Sum " + getSum(nums[j]));
    }
    
    
          
    }
    //already looping through j, then will print starting at i = 1 to leave out my  1,2,3 counting numbers.
    public static int getSum(int[] someNums){
        int total = 0;
        for (int i = 1; i < someNums.length; i++){
          total += someNums[i];
            
         
         }
        return total;
    }
}
