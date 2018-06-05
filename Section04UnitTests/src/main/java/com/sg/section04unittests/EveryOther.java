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
public class EveryOther {
      public String everyOther(String str) {
    StringBuilder stringy = new StringBuilder();
     for (int i = 0 ; i < str.length(); i ++) {
         if (i % 2 == 0){
             String sub = str.substring(i, (i+1));
             stringy.append(sub);
         } 
       }
     
    String stringed =stringy.toString();
    return stringed;
    }

}
