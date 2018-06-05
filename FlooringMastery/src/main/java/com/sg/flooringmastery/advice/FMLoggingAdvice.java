/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.advice;

import com.sg.flooringmastery.dao.FMDaoAudit;
import com.sg.flooringmastery.dao.FMDaoDataPersistException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Lizz
 */
public class FMLoggingAdvice {

    FMDaoAudit audit;

    public FMLoggingAdvice(FMDaoAudit audit) {
        this.audit = audit;
    }

    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();

        String auditEntry = jp.getSignature().getName() + ":";

        for (Object currentArg : args) {
            auditEntry += " | " + currentArg;
        }

        try {
            audit.createAuditEntry(auditEntry);
        } catch (FMDaoDataPersistException e) {
            System.err.println("Error: could not create entry");
        }
    }
    //Most exceptions will not be logged due to Spring AOP by proxy (interception). Private and nested methods are not intercepted.

    public void createAuditExceptionEntry(JoinPoint jp, Exception exc) {
        Object[] args = jp.getArgs();

        String auditEntry = jp.getSignature().getName() + ":";

        for (Object currentArg : args) {
            auditEntry += currentArg;
        }

        try {
            audit.createAuditExceptionEntry(auditEntry, exc);
        } catch (FMDaoDataPersistException e) {
            System.err.println("Error: could not create entry");
        }
    }
}
