/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.forbyfor;

/**
 *
 * @author Lizz
 */
public class ForByFor {
    public static void main(String[] args) {
   

  for(int i = 0; i<3; i++){
         System.out.print("|");
       //this if prints @@ on 2nd row of i
         if(i ==1) {
             for(int j = 0; j<3; j++){
                 
                 if( j== 1){
                     for(int k=0; k<3; k++) {
                         System.out.print("#");
                     }
                 } else {
                 for(int k =0; k<3; k++){
                     System.out.print("@");
                 }
                 }
                 System.out.print("|");
             }
         
                 
             } //this is to print i normally.
          else {
             for(int j = 0; j<3; j++){
                 //this is to run $$$ on k for j loop 2.
                 if (j==1) {
                    for(int k = 0; k<3; k++){
                        System.out.print("$");
                    } 
                 } else {
       
                 //this is to run k normally
                 for(int k =0; k<3; k++){
                     System.out.print("*");
                 }
                 }
                 
                 
                 System.out.print("|");
             }
         }
         
         
         
          System.out.println("");
  }
       
     
       
     
     /*
      for(int i = 0; i<3; i++){
         System.out.print("|");
         for(int j = 0; j<3; j++){
             for(int k=0; k<3; k++) {
                 System.out.print("*");
             }
             System.out.print("|");
         }
         System.out.println("");
     }
     
     
     
     */
    }

}


















