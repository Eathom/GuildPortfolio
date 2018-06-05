/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

/**
 *
 * @author Lizz
 */



import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao {
    
    public static final String AUDIT_FILE = "audit.txt";

    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
       PrintWriter out;
       
       try {
           out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
       
       } catch (IOException e) {
           throw new ClassRosterPersistenceException ("Couldn't write to audit", e);
       }
       LocalDateTime timestamp = LocalDateTime.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
       String formattedTS = timestamp.format(formatter);
       
       out.println(formattedTS + " : " + entry);
       out.flush();
    }

}
