/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

/**
 *
 * @author Lizz
 */
public class FMInputFormatException extends Exception{
    public FMInputFormatException(String msg) {
        super(msg);
    }

    public FMInputFormatException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
