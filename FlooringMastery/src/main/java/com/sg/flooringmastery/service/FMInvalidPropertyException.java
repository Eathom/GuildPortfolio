/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

/**
 *
 * @author Lizz
 */
public class FMInvalidPropertyException extends Exception{
        public FMInvalidPropertyException(String msg) {
        super(msg);
    }

    public FMInvalidPropertyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
