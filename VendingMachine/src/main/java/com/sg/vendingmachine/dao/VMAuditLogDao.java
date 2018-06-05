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
public interface VMAuditLogDao {
    //write to audit file, throws dao persis exc

    void writeAudit(String entry) throws VMDaoDataPersistException;

    void writeAuditExc(String itemReq, Exception exc) throws VMDaoDataPersistException;
}
