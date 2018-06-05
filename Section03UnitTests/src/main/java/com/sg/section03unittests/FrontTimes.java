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
public class FrontTimes {
    // Given a String and a non-negative int n, we'll say that the 
    // front of the String is the first 3 chars, or whatever is there 
    // if the String is less than length 3. Return n copies of the front; 
    //
    // frontTimes("Chocolate", 2) -> "ChoCho"
    // frontTimes("Chocolate", 3) -> "ChoChoCho"
    // frontTimes("Abc", 3) -> "AbcAbcAbc"

    public String frontTimes(String str, int n) {
        String result = "";
        if (str.length() > 4) {
            String first3 = str.substring(0, 3);
            for (int i = 0; i < n; i++) {
                result += first3;
            }
        } else {
            for (int i = 0; i < n; i++) {
                result += str;
            }
        }
        return result;
    }

}
