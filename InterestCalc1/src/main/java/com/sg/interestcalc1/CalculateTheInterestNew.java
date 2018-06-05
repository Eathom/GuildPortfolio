/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalc1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class CalculateTheInterestNew {

    Integer intFreq = getInput("Input the number for compound periods choice: 1. quarterly 2. monthly 3. daily  ");

    Integer timesPerYear = getFrequency(intFreq);

    BigDecimal timesPerYearBG = new BigDecimal(timesPerYear.toString());

    BigDecimal intRate = new BigDecimal(getInputStr("What is the annual interest rate?"));

    BigDecimal compoundInt = intRate.divide(timesPerYearBG, 2, RoundingMode.HALF_UP);

    BigDecimal initPrinc = new BigDecimal(getInputStr("How much will you invest?"));

    Integer yearsInFund = getInput("How many years will you stay in the fund?");
    BigDecimal yearsInFundBD = new BigDecimal(yearsInFund.toString());
    int currentYear = 1;

    BigDecimal endPrinc = new BigDecimal("0");
    BigDecimal startPrinc = initPrinc;
    BigDecimal intGain;

    public void calcInterst() {
        for (int i = 0; i < yearsInFund; i++) {

            System.out.println(" \n Current year is  " + currentYear);

            System.out.printf(" Starting principal: " + initPrinc);

            for (int j = 0; j < timesPerYear; j++) {

                endPrinc = getNewPrinc(startPrinc, compoundInt);
                startPrinc = endPrinc;

            }
            printYearly();
        }
    }

    public void printYearly() {
        System.out.printf(" Ending principal: " + endPrinc);
        intGain = endPrinc.subtract(initPrinc);
        System.out.printf(" Interest earned in year: " + intGain);
        initPrinc = startPrinc;
        currentYear++;
    }

    public String getInputStr(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String answer = sc.nextLine();
        return answer;
    }

    public static int getInput(String prompt) {
        Scanner sc = new Scanner(System.in);

        System.out.println(prompt);
        int answer = sc.nextInt();
        return answer;
    }

    public static BigDecimal getNewPrinc(BigDecimal start, BigDecimal interest) {
        BigDecimal oneHund = new BigDecimal("100");
        BigDecimal one = new BigDecimal("1");
        BigDecimal intCalc = interest.divide(oneHund, 2, RoundingMode.HALF_UP);
        BigDecimal intCalc2 = one.add(intCalc);
        BigDecimal calculatedPrinc = start.multiply(intCalc2);
        BigDecimal calcPricScaled = calculatedPrinc.setScale(2, RoundingMode.HALF_UP);

        /* BigDecimal calculatedPrinc = start * (1+ (interest / 100)); */
        return calcPricScaled;
    }

    public static Integer getFrequency(int choice) {
        Integer gotFreq;

        switch (choice) {

            case 1:
                gotFreq = 4;
                break;
            case 2:
                gotFreq = 12;
                break;
            case 3:
                gotFreq = 365;
                break;
            default:
                throw new UnsupportedOperationException("unknown");
        }
        return gotFreq;
    }
}
