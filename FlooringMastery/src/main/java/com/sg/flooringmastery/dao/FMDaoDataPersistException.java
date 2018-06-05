/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

/**
 *
 * @author Lizz
 */
public class FMDaoDataPersistException extends Exception{
         public FMDaoDataPersistException(String msg) {
        super(msg);
    }

    public FMDaoDataPersistException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
