/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

/**
 *
 * @author Lizz
 */
public class VMInputFormatException extends Exception {

    public VMInputFormatException(String msg) {
        super(msg);
    }

    public VMInputFormatException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
