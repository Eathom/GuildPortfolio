/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

/**
 *
 * @author Lizz
 */
public class DvdFilePersistenceException extends Exception {
    
    public DvdFilePersistenceException (String msg) {
        super(msg);
    }
    
    public DvdFilePersistenceException (String msg, Throwable cause) {
        super (msg, cause);
    }
    
}
