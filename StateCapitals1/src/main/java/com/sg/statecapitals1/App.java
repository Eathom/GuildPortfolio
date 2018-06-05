/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Lizz
 */
public class App {
    public static void main(String[] args) {
        Map<String, String> stateCapitals = new HashMap<>();
        
        stateCapitals.put("Alabama", "Montgomery");
         stateCapitals.put("Alaska ", "Juneau");
          stateCapitals.put("Arizona", "Phoenix");
           stateCapitals.put("Arkansas", "Little Rock");
            stateCapitals.put("California", "Sacramento");
             stateCapitals.put("Colorado", "Denver");
              stateCapitals.put("Conneticut", "Hartford");
               stateCapitals.put("Delaware", "Dover");
                stateCapitals.put("Florida", "Tallahassee");
                 stateCapitals.put("Georgia", "Atlanta");
                  stateCapitals.put("Hawaii", "Honolulu");
                   stateCapitals.put("Idaho", "Boise");
                    stateCapitals.put("Illinois", "Springfield");
                     stateCapitals.put("Indiana", "Indianapolis");
                      stateCapitals.put("Iowa", "Des Moines");
                       stateCapitals.put("Kansas", "Topeka");
                        stateCapitals.put("Kentucky", "Frankfort");
                         stateCapitals.put("Louisiana", "Baton Rouge");
                          stateCapitals.put("Maine", "Agustua");
                           stateCapitals.put("Maryland", "Annapolis");
                            stateCapitals.put("Massachusetts", "Boston");
                             stateCapitals.put("Michigan", "Lansing");
                              stateCapitals.put("Minnesota", "St Paul");
        
Set<String> states = stateCapitals.keySet();
/*
for (String currentState : states){
    String currentCapital = stateCapitals.get(currentState);
    System.out.println(currentState +  currentCapital);

}
*/

Iterator<String> iter = states.iterator();

while (iter.hasNext()){
    String currentState = iter.next();
    String currentCapital = stateCapitals.get(currentState);
    System.out.println(currentState +"," + currentCapital);
}


Collection<String> capitals = stateCapitals.values();
Iterator<String> iter1 = capitals.iterator();
while(iter1.hasNext()){
    String currentCapital = iter1.next();
    System.out.println(currentCapital);
}

/*
for (String currentCapital : capitals) {
    System.out.println(currentCapital);
}
*/





    

    }
}