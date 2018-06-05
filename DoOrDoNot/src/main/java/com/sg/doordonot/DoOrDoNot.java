/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.doordonot;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class DoOrDoNot {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Should I do it? (y/n)");
        boolean doIt;
        
        if (sc.next().equals("y")) {
            doIt = true;
        } else {
            doIt = false;
        }
        
        boolean iDidIt = false;
        
        while (doIt) {
            iDidIt = true;
            break;
        }
        
        /*
        do {
            iDidIt = true;
            break;
        } while (doIt);
        */
        
        
        
        if (doIt && iDidIt) {
            System.out.println("I did it!");
        } else if (!doIt && iDidIt) {
            System.out.println("I know you said not to, I did it anyways");
        } else {
            System.out.println("Don't look at me, I didn't do anything");
        
        
        }
        /*
        Do it? Yes. So, do it is true. I did it starts at false. Ididit will become true,
        always, due to DO.  if you said yes, and b/c DO ran, it says i did it.
        if you said no, do ran anyways, and said i did it even though yu said not to.
        
        While loop, if you tell it yes, it ididit=true and says i did it\
        if you tell it no, it skips the loop, neither ifs are met and says i didnt do anything.
        ie ididit is false(unchanged) and do it is false.
        */
    }
            
}
 