/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalc;

/**
 *
 * @author Lizz
 */
public class ControlFlow {
    
    CommandLineUserIO myIO = new CommandLineUserIO();
    SimpleCalc myCalc = new SimpleCalc();
    
    private float num1;
    private float num2;
    private int operation = 0;
    private String strOperation;    
    private float result;
    
    public void runCalc(){
       
        
        do{
            
            
            operation = myIO.getOperation("Choose operation: 1. add 2. subtract 3. multiply 4. divide 5. exit");
            
            if (operation > 0 && operation < 5){
                //get numbers to calculate
                num1 = myIO.getNum("Choose first number.");
                num2 = myIO.getNum("Choose second number.");
                
                //do a switch to chose calculation
                
                switch (operation){
                case 1: 
                    strOperation = " added to ";
                    result = myCalc.add(num1, num2);
                    break;
            
                 case 2: 
                    strOperation = " subtracted by ";
                    result = myCalc.subtract(num1, num2);
                     break;
          
                 case 3: 
                    strOperation = " multiplyed by ";
                    result = myCalc.multiply(num1, num2);
                    break;
          
                 case 4: 
                    strOperation = " divided by ";
                    result = myCalc.divide(num1, num2);
                    break;
      }  
                myIO.print(num1 + strOperation + num2 + " is: " + result + "\n");
            }
            else if (operation == 5){
                myIO.print("Thank  you");
                break;
            }
 
        } while (!(operation == 5) );
        
        
    }
    
    
}
