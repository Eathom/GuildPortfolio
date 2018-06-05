/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Lizz
 */
public class App {
    public static void main(String[] args) {
      Map<String, Capital> myMap = new HashMap();
      
      UserIOImp myIO = new UserIOImp();
      
        Capital stPaul = new Capital();
        stPaul.setName("St Paul");
        stPaul.setPopulation(276963);
        stPaul.setSqMiles(963);
        myMap.put("Minnesota", stPaul);
        
         Capital montgomery = new Capital();
        montgomery.setName("Montgomery");
        montgomery.setPopulation(200983);
        montgomery.setSqMiles(983);
        myMap.put("Alabama", montgomery);
        
         Capital juneau = new Capital();
        juneau.setName("Juneau");
        juneau.setPopulation(31118);
        juneau.setSqMiles(118);
        myMap.put("Alaska", juneau);
        
         Capital phoenix = new Capital();
        phoenix.setName("Phoenix");
        phoenix.setPopulation(1418041);
        phoenix.setSqMiles(8000);
        myMap.put("Arizona", phoenix);
        
         Capital littleRock = new Capital();
        littleRock.setName("Little Rock");
        littleRock.setPopulation(18400);
        littleRock.setSqMiles(400);
        myMap.put("Arkansas", littleRock);
        
         Capital sacramento = new Capital();
        sacramento.setName("Sacramento");
        sacramento.setPopulation(454330);
        sacramento.setSqMiles(300);
        myMap.put("California", sacramento);
        
         Capital denver = new Capital();
        denver.setName("Denver");
        denver.setPopulation(556885);
        denver.setSqMiles(885);
        myMap.put("Colorado", denver);
        
         Capital hartford = new Capital();
        hartford.setName("Hartford");
        hartford.setPopulation(128484);
        hartford.setSqMiles(465);
        myMap.put("Conneticut", hartford);
        
         Capital dover = new Capital();
        dover.setName("Dover");
        dover.setPopulation(32135);
        dover.setSqMiles(135);
        myMap.put("Delaware", dover);
        
         Capital tallahassee = new Capital();
        tallahassee.setName("Tallahassee");
        tallahassee.setPopulation(156612);
        tallahassee.setSqMiles(612);
        myMap.put("Florida", tallahassee);
        
          Capital atlanta = new Capital();
        atlanta.setName("Atlanta");
        atlanta.setPopulation(419122);
        atlanta.setSqMiles(200);
        myMap.put("Georgia", atlanta);
        
          Capital honolulu = new Capital();
        honolulu.setName("Honolulu");
        honolulu.setPopulation(37720);
        honolulu.setSqMiles(700);
        myMap.put("Hawaii", honolulu);
        
          Capital boise = new Capital();
        boise.setName("Boise");
        boise.setPopulation(190122);
        boise.setSqMiles(125);
        myMap.put("Idaho", boise);
        
          Capital springfield = new Capital();
        springfield.setName("Springfield");
        springfield.setPopulation(114783);
        springfield.setSqMiles(750);
        myMap.put("Illinois", springfield);
        
          Capital indianpolis = new Capital();
        indianpolis.setName("Indianapolis");
        indianpolis.setPopulation(784282);
        indianpolis.setSqMiles(280);
        myMap.put("Indiana", indianpolis);
        
          Capital desMoines = new Capital();
        desMoines.setName("Des Moines");
        desMoines.setPopulation(194311);
        desMoines.setSqMiles(400);
        myMap.put("Iowa", desMoines);
        
          Capital topeka = new Capital();
        topeka.setName("Topeka");
        topeka.setPopulation(122377);
        topeka.setSqMiles(370);
        myMap.put("Kansas", topeka);
        
          Capital frankfort = new Capital();
        frankfort.setName("Frankfort");
        frankfort.setPopulation(27741);
        frankfort.setSqMiles(24);
        myMap.put("Kentucky", frankfort);
        
          Capital batonRouge = new Capital();
        batonRouge.setName("Baton Rouge");
        batonRouge.setPopulation(224094);
        batonRouge.setSqMiles(497);
        myMap.put("Louisiana", batonRouge);
        
          Capital augusta = new Capital();
        augusta.setName("Augusta");
        augusta.setPopulation(18560);
        augusta.setSqMiles(185);
        myMap.put("Maine", augusta);
        
          Capital annapolis = new Capital();
        annapolis.setName("Annapolis");
        annapolis.setPopulation(36217);
        annapolis.setSqMiles(217);
        myMap.put("Maryland", annapolis);
       
        
        
        Set<String> states = myMap.keySet();
        
        for (String state: states){
            Capital currentCap = myMap.get(state);
            
            System.out.println(state + " - " + currentCap.getName() + " | Pop: " + currentCap.getPopulation() + " | Area: " + currentCap.getSqMiles() +  " sq mi");
            
        }
       
       int minPop = myIO.getMinimum();
        
       for (String state: states){
           Capital currentCap = myMap.get(state);
           int currentPop = currentCap.getPopulation();
           if (currentPop >= minPop){
               System.out.println(state + " - " + currentCap.getName() + " | Pop: " + currentCap.getPopulation() + " | Area: " + currentCap.getSqMiles() +  " sq mi");
           }
           
       }
        
        
           
        }
        
     
        
    }

