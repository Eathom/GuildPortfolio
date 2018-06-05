/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensre;

import java.util.Random;

/**
 *
 * @author Lizz
 */
class LuckySevensRe {
    
    private int roll;
    private int countRoll = 0;
    private int moniesMax = 0;
    private int rollWithMax = 0;
    private int monies = 0;
    
    public void playGame(int userInput){
         monies = userInput; 
         
           if (moniesMax < monies){
            moniesMax = monies;
            rollWithMax = countRoll;
        }
           
           
        while(monies > 0){
        roll = rollDice();
        countRoll++;
        
        //calculate money win or loss
        if (roll == 7){
            monies += 4;
        } else {
            monies -= 1;
        }

        }
    System.out.println("You are broke after " + countRoll + " rolls.");
        System.out.println("You should have quit after " + rollWithMax + " when you had $" + moniesMax);
            
        }
   
     public static int rollDice(){
        Random rGen = new Random();
        int diceOne = rGen.nextInt(6) + 1;
        int diceTwo = rGen.nextInt(6) + 1;
        int sum = diceOne + diceTwo;
        return sum;
        
        
    }
    
 
    
}



