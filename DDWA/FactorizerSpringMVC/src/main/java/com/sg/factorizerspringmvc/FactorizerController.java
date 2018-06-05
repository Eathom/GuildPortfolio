/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizerspringmvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Lizz
 */
@Controller

public class FactorizerController {
    @RequestMapping(value="factorNumber", method = RequestMethod.POST)
    public String factorNumber(HttpServletRequest request, Map<String, Object> model){
        
        List<Integer> factorList = new ArrayList<>();
        
        int factorSum = 0;
        boolean isPrime = false;
        boolean isPerfect = false;
        
        String input = request.getParameter("numberToFactor");
        int numberToFactor = Integer.parseInt(input);
        
        for (int i = 1; i < numberToFactor; i++){
            if (numberToFactor % i == 0){
                factorList.add(i);
                factorSum += i;
            }
        }
        if (factorSum == numberToFactor){
            isPerfect = true;
        }
        
        if (factorSum == 1){
            isPrime = true;
        }
        
        model.put("numberToFactor", numberToFactor);
        model.put("factors", factorList);
        model.put("isPrime", isPrime);
        model.put("isPerfect", isPerfect);
        return "result";
        
    }
    
    
}
