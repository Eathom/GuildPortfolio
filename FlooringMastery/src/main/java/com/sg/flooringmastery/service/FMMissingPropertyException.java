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
public class FMMissingPropertyException extends Exception{
        public FMMissingPropertyException(String msg) {
        super(msg);
    }

    public FMMissingPropertyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
