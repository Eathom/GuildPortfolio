/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.enums;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class App {

    
    
    public static void main(String[] args) {
       
        /*
                Scanner sc = new Scanner(System.in);
        System.out.println("What day is it?");
        String strDay = sc.nextLine();
        String upperDay  = strDay.toUpperCase();
        DaysOfWeek day = DaysOfWeek.valueOf(upperDay);
        
        System.out.println(DaysUntilFriday(day));
       
       
        
        System.out.println(calc(MathOperator.PLUS, 4, 6));
        System.out.println(calc(MathOperator.MINUS, 6, 7));
      */
        
    
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
    }
   
  public static int DaysUntilFriday(DaysOfWeek day){
      switch (day) {
          case MONDAY:
              return 4;
          case TUESDAY:
              return 3;
          case WEDNESDAY:
              return 2;
          case THURSDAY:
              return 1;
          case FRIDAY:
              return 0;
          case SATURDAY:
              return 6;
          case SUNDAY:
              return 5;
          default:
              throw new UnsupportedOperationException();
          
      }
  }
          
      public static int calc(MathOperator math, int one, int two) {
          switch (math){
              case PLUS:
                  return one + two;
              case MINUS:
                  return one - two;
              default:
                  throw new UnsupportedOperationException();
          }
      }
      
    
    
}

    

