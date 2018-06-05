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
public class MakePi {
    // Return an int array length n containing the first n digits of pi.
    //
    // makePi(3) -> {3, 1, 4}

    public int[] makePi(int n) {
        int[] pi = new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 9};
        int[] newPi = new int[n];

        for (int i = 0; i < n; i++) {
            newPi[i] = pi[i];
        }

        return newPi;
    }
}
