/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fruitsbasket;

/**
 *
 * @author Lizz
 */
public class FruitsBasket {
    public static void main(String[] args) {
   
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
   
    //VERSION 1    
       
        String[] orangesArray = new String[33];
        String[] applesArray = new String[28];
        
    int orangesCount = 0;
    int applesCount = 0;
    //33 28
        
         for(String type : fruit){
            if (type.equals("Orange")){
                
            orangesArray[orangesCount] = type;
                orangesCount++;
            } else {
                
                
            applesArray[applesCount] = type;
                applesCount++;
            }
            
 
        
    }
        
       
    
    
        System.out.println("Number of oranges: " + orangesCount);
        System.out.println("Number of apples: " + applesCount);
        
        System.out.println("Total# of Fruit in basket: " + fruit.length);
    
    
    
                


}
     }

            
        
   /*
//Could do something similar to bubble switch by sending Orange to orangeArray and putting null in fruit index to truly sort fruit instead of replicate.
 String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
 String[] orangesArr = new String[33];
 String[] applesArr = new String[28];

int orangeCount = 0;
int appleCount = 0;
*/
/* this doesn't work, enhanced loops are not good for modifying the loop you are iterating through
 for (String fruitType : fruit){
     if (fruitType.equals("Orange")){
         orangesArr[orangeCount] = "Orange";
         orangeCount++;

with enhanced loops you cannot assign with = the iterator referencing the loop; you could use a method.
         fruitType = null;
     } else {
         applesArr[appleCount] = fruitType;
         appleCount++;
         fruitType = " ";
     }
     
 }
*/
/*
 
 for (int i = 0; i< fruit.length; i++){
     if (fruit[i].equals("Orange")){
         orangesArr[orangeCount] = fruit[i];
         fruit[i] = null;
         orangeCount++;
     } else {
         applesArr[appleCount] = fruit[i];
         fruit[i] = null;
         appleCount++;
     }
    
 }
 
    for (String indexf : fruit){
        System.out.println("fruit basket: " + indexf + " ");
    }
     for (String indexo : orangesArr) {
         System.out.println("orange basket; " + indexo + " ");
     }
     for (String indexa : applesArr) {
         System.out.println("apple basket: " + indexa + " ");
     }
     
    
     
 }
 
 
    }

*/
/*
//Could also iterate through orangeArray and assign Orange once orangeArray length is determined.
String[] apples = new String[33];
String[] oranges = new String[28];

for (int i = 0; i<apples.length; i++){
    apples[i] = "Apple";
}
for (int j = 0; j < oranges.length; j++){
    oranges[j] = "Orange";
    
}
   for (String indexf : fruit){
        System.out.println("fruit basket: " + indexf + " ");
    }
     for (String indexo : oranges) {
         System.out.println("orange basket; " + indexo + " ");
     }
     for (String indexa : apples) {
         System.out.println("apple basket: " + indexa + " ");
     }

    }
}

//33 28

*/