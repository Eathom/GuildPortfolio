/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

/**
 *
 * @author Lizz
 */
public class DvdAlreadyExistsException extends Exception{
        public DvdAlreadyExistsException (String msg) {
        super(msg);
    }
    
    public DvdAlreadyExistsException (String msg, Throwable cause) {
        super (msg, cause);
    }
}
