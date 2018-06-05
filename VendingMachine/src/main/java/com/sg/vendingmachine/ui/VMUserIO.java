/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import java.math.BigDecimal;

/**
 *
 * @author Lizz
 */
public interface VMUserIO {
    //print and read various types of info incl. BigDecimal

    void print(String msg);

//input
    double readDouble(String prompt) throws VMInputFormatException ;

    double readDouble(String prompt, double min, double max) throws VMInputFormatException ;

    float readFloat(String prompt) throws VMInputFormatException ;

    float readFloat(String prompt, float min, float max) throws VMInputFormatException ;

    int readInt(String prompt) throws VMInputFormatException;

    int readInt(String prompt, int min, int max) throws VMInputFormatException;

    BigDecimal readBigDec(String prompt) throws VMInputFormatException;

    long readLong(String prompt) throws VMInputFormatException ;

    long readLong(String prompt, long min, long max) throws VMInputFormatException ;

    String readString(String prompt);
}
