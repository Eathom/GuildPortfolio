/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.advice;

import com.sg.dvdlibrary.dao.DvdAuditDao;
import com.sg.dvdlibrary.dao.DvdFilePersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Lizz
 */
public class DvdLoggingAdvice {
    DvdAuditDao audit;
    
    public DvdLoggingAdvice(DvdAuditDao audit) {
        this.audit = audit;
    }
    
    public void createEntry(JoinPoint jp){
    Object[] args = jp.getArgs();
    
    String auditEntry = jp.getSignature().getName() + ": ";
    
    for(Object currentArg: args){
        auditEntry += currentArg;
    }
    try{
        audit.writeAudit(auditEntry);
    }catch(DvdFilePersistenceException e){
        System.err.println("Error: Could not create entry");
    }
    
    }
    }

