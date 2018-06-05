/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

/**
 *
 * @author Lizz
 */
public class CanHazTable {
    // You and your date are trying to get a table at a restaurant. 
    // The parameter "you" is the stylishness of your clothes, in 
    // the range 0..10, and "date" is the stylishness of your date's 
    // clothes. The result getting the table is encoded as an int 
    // value with 0=no, 1=maybe, 2=yes. If either of you is very stylish, 
    // 8 or more, then the result is 2 (yes). With the exception that if 
    // either of you has style of 2 or less, then the result is 0 (no). 
    // Otherwise the result is 1 (maybe). 
    //
    // canHazTable(5, 10) → 2
    // canHazTable(5, 2) → 0
    // canHazTable(5, 5) → 1

    public int canHazTable(int yourStyle, int dateStyle) {

        if ((yourStyle >= 8) || (dateStyle >= 8)) {
            int result = 2;
            return result;
        } else if ((yourStyle <= 2) || (dateStyle <= 2)) {
            int result = 0;
            return result;
        } else {
            int result = 1;
            return result;
        }
    }

}
