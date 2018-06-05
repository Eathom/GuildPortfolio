/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import java.time.LocalDate;

/**
 *
 * @author Lizz
 */
public interface UserIO {
    
    void print(String msg);

    String getString(String prompt);
    
    int getInt(String prompt);
    
    int getInt(String prompt, int min, int max);
    
    LocalDate getLD(String prompt);
    
}
