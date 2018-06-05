/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rollercoaster;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class RollerCoaster {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String keepRiding = "y";
        int loopsLooped = 0;
        
        System.out.println("We're going on a rollercoaster..");
        System.out.println("Let me know when you want off.");
        //if condition is no, loop will not run.
        while(keepRiding.equalsIgnoreCase("y")){
            
            
             
                 System.out.println("Wheee!");
            System.out.println("Want to keep going? (y/n)");
            keepRiding = sc.nextLine();
            
             if (!keepRiding.equalsIgnoreCase("y") && !keepRiding.equalsIgnoreCase("n")) {
            System.out.println("Invalid input");
             } else {
            loopsLooped++;
        }
           //loopsLooped declaration involves "int", assignment doesnt need to be declared again.
             
        }
        
        System.out.println("That was fun");
        System.out.println("We looped " + loopsLooped + " times!");
            }
    }

