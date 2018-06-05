/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Lizz
 */
public class DvdAuditDaoImpl implements DvdAuditDao {

    public static final String AUDIT_FILE = "audit.txt";

    @Override
    public void writeAudit(String entry) throws DvdFilePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new DvdFilePersistenceException("Couldn't log.", e);
        }

        LocalDateTime stamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
       String formattedTS = stamp.format(formatter);

        out.println(formattedTS + " : " + entry);
        out.flush();
        out.close();
    }

}
