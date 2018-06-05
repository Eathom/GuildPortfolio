/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensspringmvc;

import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Lizz
 */
@Controller
public class LuckyController {
    
@RequestMapping(value="play", method = RequestMethod.POST)
public String play(HttpServletRequest request, Map<String, Object> model){
    String betInput = request.getParameter("betAmount");
    
    
        int bet = Integer.parseInt(betInput);

        int roll;
        int countRoll = 0;
        int rollWithMaxMoney = 0;
        int maximumMoney = 0;
        int win = 4;
        int lose = 1;

        while (bet > 0) {
            
            if (maximumMoney < bet) {
                maximumMoney = bet;
                rollWithMaxMoney = countRoll;
            }
            
            roll = rollDice();
            countRoll++;
            

            if (roll == 7) {
                bet += win;
            } else {
                bet -= lose;
            }

        }
       
    model.put("input", betInput);
    model.put("countRoll", countRoll);
     model.put("rollWithMaxMoney", rollWithMaxMoney);
      model.put("maximumMoney", maximumMoney);

    return "result";
}
private int rollDice() {
        Random rGen = new Random();
        int diceOne = rGen.nextInt(6) + 1;
        int diceTwo = rGen.nextInt(6) + 1;
        int sum = diceOne + diceTwo;
        return sum;
    }
}
