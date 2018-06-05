/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.waitawhile;

/**
 *
 * @author Lizz
 */
public class WaitAWhile {
    public static void main(String[] args) {
        
        int timeNow = 5;
        int bedTime = 10;
        
        while (timeNow < bedTime) {
            System.out.println("It is " + timeNow + " o'clock.");
            System.out.println("You can stay up later.");
            timeNow++;
        }
        System.out.println("It is " + timeNow + " o'clock."  );
        System.out.println("Time for bed.");
        }
    }

