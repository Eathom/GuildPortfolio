/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.alittlechaos;

import java.util.Random;

/**
 *
 * @author Lizz
 */
public class ALittleChaos {
    public static void main(String[] args) {
        
        Random rGen = new Random();
        
        System.out.println("Random can make integers: " + rGen.nextInt());
        System.out.println("and doubles: " + rGen.nextDouble());
        System.out.println("or booleans: " + rGen.nextBoolean());
        
        int num = rGen.nextInt(100);
        //result will be 0-99 
        
        System.out.println("A randomized result can be stored: " + num);
        System.out.println("And be used over again " + num + ", " + num);
        
        System.out.println("or keep generating new values");
        System.out.println("heres numbers from 0-100");
        
        System.out.println(rGen.nextInt(101));
        System.out.println(rGen.nextInt(101));
        System.out.println(rGen.nextInt(101));
        System.out.println(rGen.nextInt(101));
        System.out.println(rGen.nextInt(101));
        System.out.println(rGen.nextInt(101));
        /* 
        If r.nextInt(101) was r.nextInt(50) + 50 it would then be (0-49) + 50 so,
        50 - 99
         */
        System.out.println("*********************************************");
        for (int i = 0; i < 11; i++) {
        System.out.println(rGen.nextInt(50) + 50);
        }
    }
}
