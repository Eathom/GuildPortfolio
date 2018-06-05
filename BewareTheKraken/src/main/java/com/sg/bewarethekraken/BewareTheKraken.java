/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bewarethekraken;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class BewareTheKraken {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rGen = new Random();
        int depthDived = 0;
        String response = "n";
        
        String fish1 = "Ou, what a puffy pufferfish!";
        String fish2 = "Look at that mighty stinkray!";
        String fish3 = "SHARK!";
        
        System.out.println("We're going diving, kick off those flippy-floppies.");
        
        // ocean is 36200 ft deep.
        while(depthDived < 36200) {
            System.out.println("So far we've dived " + depthDived + " feet.");
            
            if (depthDived == 10000) {
                System.out.println("We're 10000 feet in, do you want to turn back? (y/n)");
                response = sc.nextLine();
                if (response.equals("y")) {
                    System.out.println("Going Up!");
                    break;
                } else {
                    System.out.println("Continuing on");
                }
                
            }
            if(depthDived >= 20000) {
                System.out.println("I think I see a Kraken. o.O ");
                System.out.println("TIME TO GO.");
                break;
                
            }
            depthDived += 1000;
            int randomFishChooser = rGen.nextInt(3)+1;
            if (randomFishChooser == 1){
                System.out.println(fish1);
            } else if (randomFishChooser == 2) {
                System.out.println(fish2);
            } else {
                System.out.println(fish3);
            }
            
        }
        System.out.println("");
        System.out.println("We swam " + depthDived + " feet.");
        System.out.println("We can do better next time!");
    }
}
