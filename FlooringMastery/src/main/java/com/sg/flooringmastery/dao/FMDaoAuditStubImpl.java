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
public class FMDaoAuditStubImpl implements FMDaoAudit{

    @Override
    public void createAuditEntry(String entry) throws FMDaoDataPersistException {
       //Do nothing.
    }

    @Override
    public void createAuditExceptionEntry(String entry, Exception exc) throws FMDaoDataPersistException {
        //Do nothing.
    }

   
    
}
