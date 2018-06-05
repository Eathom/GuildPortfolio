/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bigdeccodealong;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Lizz
 */
public class BigDecMath {
    
    
public BigDecimal calc(MathOperator operator, BigDecimal one, BigDecimal two) {
    
    switch(operator) {
        case PLUS:
            return one.add(two);
        case MINUS:
            return one.subtract(two);
        case MULTIPLY:
            return one.multiply(two);
        case DIVIDE:
            return one.divide(two, 2, RoundingMode.HALF_UP);
        default:
            throw new UnsupportedOperationException("unknown math operator");
    }
}    
}
