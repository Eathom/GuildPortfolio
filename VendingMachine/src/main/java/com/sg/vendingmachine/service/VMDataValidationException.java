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
public class VMDataValidationException extends Exception {

    public VMDataValidationException(String msg) {
        super(msg);
    }

    public VMDataValidationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
