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
public class LongInMid {
       // Given 2 Strings, a and b, return a String of the form 
    // short+long+short, with the shorter String on the outside 
    // and the longer String on the inside. The Strings will not 
    // be the same length, but they may be empty (length 0). 
    //
    // longInMiddle("Hello", "hi") -> "hiHellohi"
    // longInMiddle("hi", "Hello") -> "hiHellohi"
    // longInMiddle("aaa", "b") -> "baaab"
    public String longInMiddle(String a, String b) {
      Integer intA = a.length();
      Integer intB = b.length();
      String result;
      int compared = intA.compareTo(intB);
      
      if (compared > 0){
          return result = b.concat(a).concat(b);
      } else{
         return result = a.concat(b).concat(a);
      }
    }
 
}
