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
public interface FMDaoAudit {
    void createAuditEntry(String entry) throws FMDaoDataPersistException;
    
    void createAuditExceptionEntry(String entry, Exception exc) throws FMDaoDataPersistException;
}
