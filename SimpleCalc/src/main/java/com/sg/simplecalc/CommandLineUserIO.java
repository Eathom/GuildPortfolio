/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalc;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class CommandLineUserIO implements UserIO {
      Scanner sc = new Scanner(System.in);

    
    @Override
    public float getNum(String prompt){
        System.out.println(prompt);
        return sc.nextInt();
    }
    
    @Override
    public int getOperation(String prompt){
        System.out.println(prompt);
        return sc.nextInt();
    }
    
    @Override
    public void print(String prompt){
        System.out.println(prompt);
    }
}
