/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook;

import java.util.ArrayList;

/**
 *
 * @author Lizz
 */
public interface UserIO {
 
    
   String getStringInput(String prompt);
   int getIntInput(String prompt);
   void showAddress(ArrayList<Address> e);
   void showNum(int size);
   
}
