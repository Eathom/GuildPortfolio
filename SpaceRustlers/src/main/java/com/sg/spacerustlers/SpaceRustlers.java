/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.spacerustlers;

/**
 *
 * @author Lizz
 */
public class SpaceRustlers {
    public static void main(String[] args) {
        /*
        Type in the following code, make it work!
What does the else if and if do? (Answer in a comment)
If you remove the else from the else if, what does THAT do? (Answer in a comment)
Add in another if/else block that prints out:
"Hurrah, we've got the grub! Hamburger party on Alpha Centauri!" if the aliens outnumber the cows but if the cows equal or outnumber the aliens print out "Oh no! The herds got restless and took over! Looks like _we're_ hamburger now!!"
        */
        int spaceships = 10;
        int aliens = 25;
        int cows = 10;
        
        if (aliens > spaceships) {
            System.out.println("Vroom, lets get going");
        } else {
            System.out.println("There aren't enough drivers");
        }
        
        if (cows == spaceships) {
            System.out.println("Just enough room for these cows");
            //next line, removed else from else if- treats like new if else statement
        }  if (cows > spaceships) {
            System.out.println("Can't fit all the cows in spaceship");
        }else {
            System.out.println("Too many ships, not enough cows");
        }
        
        if (aliens > cows ) {
            System.out.println("Hamburger party");
        }
        else {
            System.out.println("we're hamburger, cows took over");
        }
    }
}
