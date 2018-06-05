/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.zork;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class Zork {
       public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");
        
        String action = userInput.nextLine();
        //not done: door, window 
        if (action.equals("open the mailbox")) {
             System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();
        }
        
        if (action.equals("look inside")) {
           System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();
       }
          if (action.equals("keep looking")) {
                    System.out.println("You've been eaten by a grue THE END");
          }
          //went down the chain, now working back out w/ other options using else if
          else if (action.equals("run away")) {
              System.out.println("You run away and live  THE END");
          }
          else if (action.equals("stick hand inside")) {
              System.out.println("You stick your hand inside -SHOULD END GAME?");
          }
          else if (action.equals("house")) {
              System.out.println("End game or continue? try continue");
              System.out.println("Do you want to open door, look through window");
              action = userInput.nextLine();
          }
          if (action.equals("open door")) {
              System.out.println("Open door");
          }
          else if (action.equals("window")) {
              System.out.println("the end");
          }
       }
}
    
