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
public class VMAuditDaoStubImpl implements VMAuditLogDao {

    @Override
    public void writeAudit(String entry) {
        //do nothing
    }

    @Override
    public void writeAuditExc(String itemReq, Exception exc) throws VMDaoDataPersistException {
        //do nothing
    }

}
