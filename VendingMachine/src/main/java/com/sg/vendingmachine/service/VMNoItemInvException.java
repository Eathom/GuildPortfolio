/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

/**
 *
 * @author Lizz
 */
public class VMNoItemInvException extends Exception {
    //item will not show in menu, but may still be selected, thrown if none in inventory

    public VMNoItemInvException(String msg) {
        super(msg);
    }

    public VMNoItemInvException(String msg, Throwable cause) {
        super(msg, cause);
    }

    @Override
    public String toString() {
        return "NoItemInvException thrown: ";
    }
}
