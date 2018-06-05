/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.birthstones;

import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class Birthstones {
    public static void main(String[] args) {
        
        int num;
        String month = "";
        String stone = "";
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Pick a month number for birthstone");
        num = sc.nextInt();
        
        if (num == 1){
            month = "Jan";
            stone = "garnet";
           
        } else  if (num == 2){
            month = "Jan";
            stone = "garnet";
            
        } else  if (num == 3){
            month = "Mar";
            stone = "Aquamarine";
            
        } else  if (num == 4){
            month = "Apr";
            stone = "diamond";
           
        } else if (num == 5){
            month = "may";
            stone = "emerald";
            
        } else if (num == 6){
            month = "june";
            stone = "pearl";
            
        } else if (num == 7){
            month = "july";
            stone = "ruby";
           
        }
        else {
            System.out.println("error");
        }
        
       System.out.println(month + " is " + stone);  
    }
    
}
