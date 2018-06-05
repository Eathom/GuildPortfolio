/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizz
 */
public class StringTimes {
    // Given a String and a non-negative int n, return a larger String 
    // that is n copies of the original String. 
    //
    // stringTimes("Hi", 2) -> "HiHi"
    // stringTimes("Hi", 3) -> "HiHiHi"
    // stringTimes("Hi", 1) -> "Hi"

    public String stringTimes(String str, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += str;
        }

        return result;

    }

}
