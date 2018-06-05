/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.doggenetics1;

/**
 *
 * @author Lizz
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class DogGenetics1 {
    public static void main(String[] args) {
        
    
    Random rGen = new Random();
    Scanner sc = new Scanner(System.in);
    
    int doxy, chihuahua, jackRussell, retriever, pug; 
   
    
    
    int numRemaining = 95;
    String name;
    
        System.out.print("What is your dog's name? ");
        name = sc.nextLine();
        System.out.println("I have this highly reliable DNA genetics report for " + name + ". \n");
        
        System.out.println(name + " is: \n");
  
        
        doxy = 1;
        chihuahua = 1;
        jackRussell = 1;
        retriever = 1;
        pug = 1;
        int tempNumber = 0;
        
        tempNumber = rGen.nextInt(numRemaining)+1;
        numRemaining -= tempNumber;
              doxy += tempNumber  ;
        System.out.println("tempNum: " + tempNumber +  " numRemaining: "  + numRemaining + " doxy: " + doxy);
        
       if (numRemaining > 0){ 
           tempNumber = rGen.nextInt(numRemaining) + 1;
        numRemaining -= tempNumber;
              chihuahua += tempNumber  ;
        System.out.println("tempNum: " + tempNumber +  " numRemaining: "  + numRemaining + " chi: " + chihuahua);
       }
        
       if (numRemaining > 0) {
           tempNumber = rGen.nextInt(numRemaining) + 1;
      numRemaining -= tempNumber;
              jackRussell += tempNumber  ;
        System.out.println("tempNum: " + tempNumber +  " numRemaining: "  + numRemaining + " jackR: " + jackRussell);
       }
       if (numRemaining > 0){
        tempNumber = rGen.nextInt(numRemaining) + 1;
        numRemaining -= tempNumber;
              retriever += tempNumber  ;
        System.out.println("tempNum: " + tempNumber +  " numRemaining: "  + numRemaining + " retriever: " + retriever);
       }
        if (numRemaining > 0){
            pug += numRemaining;
       System.out.println("remain " + numRemaining + "pug " + pug);
        }
        
        
        
                
                
                
        System.out.println(doxy + "% Dachshund");
        System.out.println(chihuahua + "% Chihuahua");
        System.out.println(jackRussell + "% Jack Russell Terrier");
        System.out.println(retriever + "% Retriever");
        System.out.println(pug + "% Pug");
        
    }
}