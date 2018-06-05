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
public class CountXX {
    // Count the number of "xx" in the given String. We'll say 
    // that overlapping is allowed, so "xxx" contains 2 "xx".  
    //
    // countXX("abcxx") -> 1
    // countXX("xxx") -> 2
    // countXX("xxxx") -> 3

    public int countXX(String str) {
        String toFind = "xx";
        int count = 0;
        int index = 0;
        int lastIndex = -1;
        for (int i = 0; i < str.length(); i++) {

            index = str.indexOf(toFind, i);

            if (index > lastIndex) {
                count++;
                lastIndex = index;
            }

        }

        return count;
    }

}
