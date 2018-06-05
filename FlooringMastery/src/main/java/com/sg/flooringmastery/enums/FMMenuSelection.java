/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.enums;

/**
 *
 * @author Lizz
 */
public enum FMMenuSelection {
       DISPLAY, ADD, EDIT, REMOVE, SAVE, QUIT, NOTSET;
    
    public static FMMenuSelection getMenuChoice(int menuSelection){
        
        switch(menuSelection){
            case 1:
                return DISPLAY;
             case 2:
                return ADD;
                 case 3:
                return EDIT;
                 case 4:
                return REMOVE;
                 case 5:
                return SAVE;
                 case 6:
                return QUIT;
             default:
                 //this can never happen
                 return NOTSET;
                
        }
    }
   
}
