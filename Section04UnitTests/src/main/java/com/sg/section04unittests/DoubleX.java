/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

/**
 *
 * @author Lizz
 */
public class DoubleX {
    public boolean doubleX(String str){
      int indexOfX = str.indexOf("x");
      int indexOfXX = str.indexOf("xx");
      if (indexOfX == indexOfXX){
          return true;
      } else {
      return false;
        }
        
        
    }
}
