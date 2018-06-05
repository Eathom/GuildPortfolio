/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

/**
 *
 * @author Lizz
 */
public class VMInsuffFundsException extends Exception {
    // thrown - add money, chose item, item costs too much

    public VMInsuffFundsException(String msg) {
        super(msg);
    }

    public VMInsuffFundsException(String msg, Throwable cause) {
        super(msg, cause);
        
    }

 @Override
public String toString(){
    return "InsuffFundsException thrown: ";
}
}
