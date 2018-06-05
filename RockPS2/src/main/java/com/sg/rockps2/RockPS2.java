/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockps2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class RockPS2 {
   
        Scanner sc = new Scanner(System.in);
        Random rGen = new Random();
        
        int rounds = 0;
        int p1Choice;
        int p2Choice;
        int p1Win = 0;
        int p2Win = 0;
        int tie = 0;
        String winner = " ";
        String play = " ";
        
        
        
        
        
    public void playGame(){    
        
        
        do {
            System.out.println("Enter how many rounds (between 1 and 10) of rock, paper, scissors you want to play ");
            rounds = sc.nextInt();
            sc.nextLine();
            if (rounds < 1 || rounds > 10){
                System.out.println("Invalid answer");
                break;
            } else { 
                for (int i = 0; i < rounds; i++){
                   do { 
                       p1Choice = getChoice();
                       if (p1Choice < 1 || p1Choice > 3){
                           System.out.println("Invalid answer, please try again.");
                       }
                   } while (p1Choice < 1 || p1Choice > 3);
                   
                   p2Choice = rGen.nextInt(3)+ 1;
                    printP2(p2Choice);
                    
                    if(p1Choice == p2Choice){
                        System.out.println("It's a tie!");
                        tie++;
                    } else if (p1Choice == 1){
                         if (p2Choice == 2){
                             System.out.println("Computer wins!");
                             p2Win++;
                         }else{
                             System.out.println("You won!");
                             p1Win++;
                         }
                     } else if (p1Choice == 2){
                         if (p2Choice == 3){
                             System.out.println("Computer wins!");
                             p2Win++;
                         } else {
                             System.out.println("You won!");
                             p1Win++;
                         }
                     } else {
                         if (p2Choice == 1){
                             System.out.println("Computer wins!");
                             p2Win++;
                         }else {
                             System.out.println("You won!");
                             p1Win++;
                         }
                     }
                    
                    
                }
                System.out.println("There were " + tie + " rounds tied up.");
                System.out.println("You won " + p1Win + " rounds.");
                System.out.println("Computer won " + p2Win + " rounds.");
                winner = calcWins(p1Win, p2Win);
                System.out.println(winner);
                
                tie = 0;
                p1Choice = 0;
                p2Choice = 0;
                
            }
            System.out.println("Do you want to play again? (y/n)");
                 play = sc.nextLine();
        }while (play.equals("y"));
        System.out.println("Thanks for playing!");
                
    }   
        
    
    public static int getChoice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in your choice of rock, paper, or scissors" );
        String strChoice = sc.nextLine();
        int choice=0;
        switch (strChoice){
            case "rock": choice = 1;
            break;
            case "paper": choice = 2;
            break;
            case"scissors": choice = 3;
            break;
        }
        return choice;    
     }
    public static String calcWins(int p1, int p2){
        String result= " ";
        if (p1 == p2){
            result = "It was a tie!";
        } else if (p1 > p2){
            result = "You is the victor!";
        } else {
            result = "Computer wins the spoils!";
        }
     return result;   
    }
     public static void printP2(int p2Choice){
       String choice= " ";
       
         switch (p2Choice){
            case 1: choice = "rock";
            break;
            case 2: choice = "paper";
            break;
            case 3: choice = "scissors";
            break;
        }
        
       
       
        System.out.println("Computer chose: " + choice );
        
       
      
     
    
}
}
