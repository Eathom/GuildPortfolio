/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

/**
 *
 * @author Lizz
 */
public class PosNeg {
        // Given two int values, return true if one is negative and 
    // one is positive. Except if the parameter "negative" is 
    // true, then return true only if both are negative. 
    //
    // posNeg(1, -1, false) -> true
    // posNeg(-1, 1, false) -> true
    // posNeg(-4, -5, true) -> true
    public boolean posNeg(int a, int b, boolean negative) {
       if (negative && (a < 0 && b < 0)){
           return true;
       }else if ((a <0 && b > 0) || (b < 0 && a > 0)){
           return true;
           } else {
           return false;
               
       }
    }

}
