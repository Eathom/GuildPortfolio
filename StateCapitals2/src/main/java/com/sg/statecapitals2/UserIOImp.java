/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class UserIOImp implements UserIO {
 Scanner sc = new Scanner(System.in);
    
 @Override
 public Integer getMinimum(){
     System.out.println("Enter a minimum population to view.");
      int minPop = sc.nextInt();
     return minPop;
 }   
    
}
