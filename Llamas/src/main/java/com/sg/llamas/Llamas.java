/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.llamas;

/**
 *
 * @author Lizz
 */
public class Llamas {
    public static void main(String[] args) {
        
        int llamas = 20;
        int whales = 15;
        int dodos = 0;
        
        
        if (dodos > 0) {
            System.out.println("Dodos are extinct");
        }
        if (dodos < 0) {
            System.out.println("Negative dodos");
        }
        if (llamas > whales) {
            System.out.println("whales are bigger, but llams are better");
        }
        if (llamas <= whales){
            System.out.println("whales beat llamas");
        }
        System.out.println("theres been dodo cloning");
        dodos += 100;
        
        if ((whales + llamas) < dodos) {
            System.out.println("dodocs rule earth");
           // llamas =+ 200;
        }
        if (llamas > whales && llamas > dodos) {
            System.out.println("llamas come out ahead");
        }
    }
}
