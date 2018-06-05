/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bigdeccodealong;

import java.math.BigDecimal;

/**
 *
 * @author Lizz
 */
public class App {
    public static void main(String[] args) {
        BigDecMath big = new BigDecMath();
        
        BigDecimal op1 = new BigDecimal("10");
        BigDecimal op2 = new BigDecimal("6");
        
        System.out.println(big.calc(MathOperator.PLUS, op1, op2));
         System.out.println(big.calc(MathOperator.MINUS, op1, op2));
          System.out.println(big.calc(MathOperator.MULTIPLY, op1, op2));
           System.out.println(big.calc(MathOperator.DIVIDE, op1, op2));
        
    }
}
