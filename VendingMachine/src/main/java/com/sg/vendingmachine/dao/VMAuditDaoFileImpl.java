/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Lizz
 */
public class VMAuditDaoFileImpl implements VMAuditLogDao {

    public static final String AUDIT_FILE = "audit.txt";

    @Override
    public void writeAudit(String entry) throws VMDaoDataPersistException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new VMDaoDataPersistException("Couldn't log to file", e);
        }

        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String formattedTS = timestamp.format(formatter);

        out.println(formattedTS + " : " + entry);
        out.flush();
    }

    @Override
    public void writeAuditExc(String entry, Exception exc) throws VMDaoDataPersistException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new VMDaoDataPersistException("Couldn't log to file", e);
        }

        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String formattedTS = timestamp.format(formatter);

        out.println(formattedTS + " : " + exc + " " + exc.getMessage() + " |" + entry);
        out.flush();
        out.close();

    }
}
