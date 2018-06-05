/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class FMUserIOConsoleImpl implements FMUserIO {

    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) throws FMInputFormatException {
        double input;
        System.out.println(prompt);
        String strInput = sc.nextLine();
        try {
            input = Double.parseDouble(strInput);

        } catch (NumberFormatException e) {
            throw new FMInputFormatException("Must input a number.", e);
        }
        return input;
    }

    @Override
    public double readDouble(String prompt, double min, double max) throws FMInputFormatException {
        String strInput;
        double input;

        do {
            System.out.println(prompt);
            strInput = sc.nextLine();
            try {
                input = Double.parseDouble(strInput);
            } catch (NumberFormatException e) {
                throw new FMInputFormatException("Must input a number.", e);
            }
        } while (input < min || input > max);

        return input;
    }

    @Override
    public float readFloat(String prompt) throws FMInputFormatException {
        float input;
        System.out.println(prompt);

        String strInput = sc.nextLine();

        try {
            input = Float.parseFloat(strInput);
        } catch (NumberFormatException e) {
            throw new FMInputFormatException("Must input a number.", e);
        }
        return input;
    }

    @Override
    public float readFloat(String prompt, float min, float max) throws FMInputFormatException {
        String strInput;
        float input;

        do {
            System.out.println(prompt);

            strInput = sc.nextLine();
            try {
                input = Float.parseFloat(strInput);
            } catch (NumberFormatException e) {
                throw new FMInputFormatException("Must input a number.", e);
            }
        } while (input < min || input > max);

        return input;
    }

    @Override
    public int readInt(String prompt) throws FMInputFormatException {
        System.out.println(prompt);
        String strInput = sc.nextLine();
        int input;
        try {
            input = Integer.parseInt(strInput);
        } catch (NumberFormatException e) {
            //an exception translation
            throw new FMInputFormatException("must input a number", e);
        }
        return input;
    }

    @Override
    public int readInt(String prompt, int min, int max) throws FMInputFormatException {
        String strInput;
        int input;

        do {
            System.out.println(prompt);
            strInput = sc.nextLine();
            try {
                input = Integer.parseInt(strInput);
            } catch (NumberFormatException e) {
                throw new FMInputFormatException("must input a number", e);
            }
        } while (input < min || input > max);

        return input;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) throws FMInputFormatException {
        System.out.println(prompt);
        String strInput = sc.nextLine();
        BigDecimal input;
        try {
            input = new BigDecimal(strInput);
        } catch (NumberFormatException e) {
            throw new FMInputFormatException("must input a number", e);
        }
        return input;
    }

    @Override
    public long readLong(String prompt) throws FMInputFormatException {
        long input;
        System.out.println(prompt);
        String strInput = sc.nextLine();
        try {
            input = Long.parseLong(strInput);
        } catch (NumberFormatException e) {
            throw new FMInputFormatException("Must input a number.", e);
        }
        return input;
    }

    @Override
    public long readLong(String prompt, long min, long max) throws FMInputFormatException {
        String strInput;
        long input;

        do {
            System.out.println(prompt);
            strInput = sc.nextLine();
            try {
                input = Long.parseLong(strInput);
            } catch (NumberFormatException e) {
                throw new FMInputFormatException("Must input a number.", e);
            }
        } while (input < min || input > max);

        return input;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    @Override
    public LocalDate readDate(String prompt) throws FMInputFormatException {
        LocalDate ld;
        System.out.println(prompt);
        String strDate = sc.nextLine();
        try {
            ld = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        } catch (DateTimeParseException e) {
            throw new FMInputFormatException("Date entered incorrectly", e);
        }
        return ld;
    }

}
