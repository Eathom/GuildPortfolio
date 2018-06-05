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
public class DvdNotFoundException extends Exception {
       public DvdNotFoundException (String msg) {
        super(msg);
    }
    
    public DvdNotFoundException (String msg, Throwable cause) {
        super (msg, cause);
    }
}
