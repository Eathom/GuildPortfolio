/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

/**
 *
 * @author Lizz
 */
public class VMDaoDataPersistException extends Exception {
    // will translate exception for writing or loading the txt file

    public VMDaoDataPersistException(String msg) {
        super(msg);
    }

    public VMDaoDataPersistException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
