/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.forandtwenty;

/**
 *
 * @author Lizz
 */
public class ForAndTwenty {
    public static void main(String[] args) {
        
        int birds = 0;
        
        for (int i = 1; i <25 ; i++){
            
            System.out.println("Blackbird # " + i + " goes into the pie!");
            birds ++;
        }
        
        System.out.println("There are " + birds + " birds in there!");
        System.out.println("Quite a bunch!");
    }
}

/*
originial was

int birds = 0;
for (int i = 0; i < 24; i++){
sout("blackbirds #" + i + " added to pie");
birds++
}


this added a blackbird 0 to the pie (doesn't make sense) 
had to change i to 1, and increase it to <25 to keep it so that birds is ++ 24 times.

*/