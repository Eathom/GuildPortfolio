/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Lizz
 */
public class FMDaoAuditFileImpl implements FMDaoAudit {

    public static final String AUDIT_FILE = "audit.txt";

    @Override
    public void createAuditEntry(String entry) throws FMDaoDataPersistException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new FMDaoDataPersistException("Couldn't write audit entry", e);
        }

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
        String stamp = ldt.format(formatter);
        out.println(stamp + ":" + entry);

        out.flush();
        out.close();
    }

    @Override
    public void createAuditExceptionEntry(String entry, Exception exc) throws FMDaoDataPersistException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new FMDaoDataPersistException("Couldn't write audit entry", e);
        }

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
        String stamp = ldt.format(formatter);
        out.println(stamp.toString() + ":" + exc + "|" + entry);

        out.flush();
        out.close();
    }
}
