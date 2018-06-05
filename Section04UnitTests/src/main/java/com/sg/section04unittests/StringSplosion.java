/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

import java.util.Arrays;

/**
 *
 * @author Lizz
 */
public class StringSplosion {
     
    
    // Given a non-empty String like "Code" return a String like 
    // “CCoCodCode".  (first char, first two, first 3, etc)
    //
    // stringSplosion("Code") -> "CCoCodCode"
    // stringSplosion("abc") -> "aababc"
    // stringSplosion("ab") -> "aab"
    public  String stringSplosion(String str) {
        int stringLength = str.length();
        String[] strings = new String[stringLength];
      
        for (int i = 0; i < str.length(); i++){
            strings[i] = str.substring(0, (i+1));
        }
       
     String stringResult = Arrays.toString(strings);
     String result = stringResult.replace(", " , "");
    String result1 = result.substring(1, result.length() - 1);
    
       return result1;
    


}
}