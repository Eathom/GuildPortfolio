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
public class CommonEnd {
    
    
    public boolean commonEnd(int[] a, int[] b) {
 
     int endA = a[a.length - 1];
     int endB = b[b.length - 1];
     
     if (endA == endB){
         return true;
     } else {
         return false;
     }
     
   }
}
