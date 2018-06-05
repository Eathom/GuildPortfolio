/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.healthyhearts2;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class HealthyHearts2 {
    public static void main(String[] args) {
        
        int age = getAge("What's your age?");
         
         
        int maxRate = 220 - age;
        
        float targetMin = .50f * maxRate;
        float targetMax = .85f * maxRate;
        
        int intTargetMin = Math.round(targetMin);
        int intTargetMax = Math.round(targetMax);        
        
       
         
         System.out.println("Your maximum heart rate should be " + maxRate + " beats per minute.");
         System.out.println("Your target HR Zone is " + intTargetMin + " - " + intTargetMax + " beats per minute.");
         
         
         
    }
    public static int getAge(String prompt){
        Scanner sc = new Scanner(System.in );
        System.out.println(prompt);
        int age = sc.nextInt();
        return age;
    }
}
