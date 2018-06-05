/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

import static java.lang.Math.abs;

/**
 *
 * @author Lizz
 */
public class NearHund {
      // Given an int n, return true if it is within 10 of 100 
    // or 200.
    // Hint: Check out the Math class for absolute value
    //
    // nearHundred(103) -> true
    // nearHundred(90) -> true
    // nearHundred(89) -> false
    public boolean nearHundred(int n) {
        int sum1 = 100 - n;
        int absSum1 = abs(sum1);
        
        int sum2 = 200 - n;
        int absSum2 = abs(sum2);
        
        if (absSum1 <= 10) {
            return true;
        } else if (absSum2 <= 10){
            return true;
        } else {
            
       return false;
    }
  
}
}
