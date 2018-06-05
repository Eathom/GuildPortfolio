/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fruitsalad;

/**
 *
 * @author Lizz
 */
public class FruitSalad {
    public static void main(String[] args) {
        
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
       
        
        String[] fruitSalad = new String[12];
        int count = 0;
        int appleCount = 0;
        int orangeCount = 0;
        
        for (int i=0; i< fruit.length; i++){
         if (count < 12){ 
             if (fruit[i].contains("berry")){
             fruitSalad[count] = fruit[i];  
                     count++;
                } else if (fruit[i].contains("Apple") && appleCount < 3){
            fruitSalad[count] = fruit[i];
            appleCount++;
             count++;
        } else if (fruit[i].contains("Orange") && orangeCount < 2){
            fruitSalad[count] = fruit[i];
             count++;
            
            orangeCount++;
        } else if (!fruit[i].contains("Tomato") ){
            fruitSalad[count] = fruit[i];
             count++;
        
        
             
          }
         }
    }
        
        
        
       for (String element : fruitSalad){
           System.out.println(element);
       }
        }
     
    }

