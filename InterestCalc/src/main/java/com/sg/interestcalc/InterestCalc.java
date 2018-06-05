/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalc;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class InterestCalc {
    public static void main(String[] args) {
        


int intFreq = getInput("Input the number for compound periods choice: 1. quarterly 2. monthly 3. daily  ");
int timesPerYear = getFrequency(intFreq);

float compoundInt = getInputf("What is the annual interest rate?") / timesPerYear;


float initPrinc = getInputf("How much will you invest?");

int yearsInFund = getInput("How many years will you stay in the fund?");

int currentYear = 1;


float endPrinc = 0;
float startPrinc = initPrinc;
float intGain;   

for (int i = 0; i < yearsInFund; i++){
    
    System.out.println(" \n Current year is  " + currentYear);
    
    System.out.printf(" Starting principal: " + "%.2f", initPrinc);
    
    for (int j = 0; j < timesPerYear; j++){
      
        endPrinc = getNewPrinc(startPrinc, compoundInt);
        startPrinc = endPrinc;
     }
    
    
    
    System.out.printf(" Ending principal: "  +  "%.2f", endPrinc);
    intGain = endPrinc - initPrinc;
    System.out.printf(" Interest earned in year: " + "%.2f", intGain) ;
    initPrinc = startPrinc;
    currentYear++;
}


    }
    public static float getInputf( String prompt){
         Scanner sc = new Scanner(System.in);
         
        System.out.println(prompt);
      float answer = sc.nextInt();
      return answer;
    }
     public static int getInput( String prompt){
         Scanner sc = new Scanner(System.in);
         
        System.out.println(prompt);
      int answer = sc.nextInt();
      return answer;
     }
     public static float getNewPrinc(float start, float interest){
         float calculatedPrinc = start * (1+ (interest / 100));
         return calculatedPrinc;
     }
    public static int getFrequency(int intChoice){
        int gotFreq = 0;
        switch (intChoice){
            case 1: gotFreq = 4;
            break;
            case 2: gotFreq = 12;
            break;
            case 3: gotFreq = 365;
            break;
        }
        return gotFreq;
    }
}