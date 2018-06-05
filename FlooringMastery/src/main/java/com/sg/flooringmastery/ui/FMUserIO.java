/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Lizz
 */
public interface FMUserIO {

    void print(String msg);

//input
    double readDouble(String prompt) throws FMInputFormatException;

    double readDouble(String prompt, double min, double max) throws FMInputFormatException;

    float readFloat(String prompt) throws FMInputFormatException;

    float readFloat(String prompt, float min, float max) throws FMInputFormatException;

    int readInt(String prompt) throws FMInputFormatException;

    int readInt(String prompt, int min, int max) throws FMInputFormatException;

    BigDecimal readBigDecimal(String prompt) throws FMInputFormatException;

    long readLong(String prompt) throws FMInputFormatException;

    long readLong(String prompt, long min, long max) throws FMInputFormatException;

    String readString(String prompt);

    LocalDate readDate(String prompt) throws FMInputFormatException;
}
