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
public enum FMModeSelection {

    TRAINING, PRODUCTION, STUB, NOTSET;

    //stub will not be an option on the menu, it is used for test unit file
    public static FMModeSelection getMode(int modeSelection) {

        switch (modeSelection) {
            case 1:
                return TRAINING;
            case 2:
                return PRODUCTION;
            default:
                return NOTSET;

        }
    }

}
