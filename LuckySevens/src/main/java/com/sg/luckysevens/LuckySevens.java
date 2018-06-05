/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class LuckySevens {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("How many dollars do you have?");
        int monies = sc.nextInt();
        int roll;
        int countRoll = 0;
        int moniesMax = 0;
        int rollWithMax = 0;
        
        
        while(monies > 0){
        roll = rollDice();
        countRoll++;
        
        //calculate money win or loss
        if (roll == 7){
            monies += 4;
        } else {
            monies -= 1;
        }
        
        //set max money and track roll
        if (monies > moniesMax){
            moniesMax = monies;
            rollWithMax = countRoll;
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





