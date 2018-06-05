/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringcalcspringmvc;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class FlooringController {
    @RequestMapping(value="calculate", method = RequestMethod.POST)
    public String calculate(HttpServletRequest request, Map<String, Object> model){
       String widthInput = request.getParameter("width");
        String lengthInput = request.getParameter("length");
        String costInput = request.getParameter("cost");
        
        BigDecimal width = new BigDecimal(widthInput);
        BigDecimal length = new BigDecimal(lengthInput);
        BigDecimal cost = new BigDecimal(costInput);
        
         BigDecimal area = width.multiply(length);
        BigDecimal totalMtrlCost = area.multiply(cost);
        //install 5 sq ft per 15 minutes
        BigDecimal installRate = new BigDecimal("5");
        //how many 15 minute increments
        BigDecimal increments = new BigDecimal("15");
        BigDecimal totalIncrements = area.divide(installRate, RoundingMode.CEILING);
        BigDecimal totalMinutes = totalIncrements.multiply(increments);
        BigDecimal minInHr = new BigDecimal("60");
        
        BigDecimal hours = totalMinutes.divide(minInHr, RoundingMode.FLOOR);
        BigDecimal minutes = totalMinutes.remainder(minInHr);
        //how much labor cost per 15 minutes
        BigDecimal installPrice = new BigDecimal("21.5");
        BigDecimal totalLabor = totalMinutes.multiply(installPrice);
        
        BigDecimal grandTotal = totalMtrlCost.add(totalLabor);
        
        model.put("width", width);
        model.put("length", length);
        model.put("cost", cost);
        
        model.put("mtrlCost", totalMtrlCost);
        model.put("laborCost", totalLabor);
        model.put("hours", hours);
        model.put("minutes", minutes);
        model.put("totalCost", grandTotal);
        
        return "result";
    }
}
