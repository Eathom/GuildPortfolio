/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculatorspringmvc;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class InterestController {
    @RequestMapping(value = "calculate", method = RequestMethod.POST)
    public String calculate(HttpServletRequest request, Map<String, Object> model){
        Integer timesPerYear = 4;

    BigDecimal timesPerYearBG = new BigDecimal(timesPerYear.toString());
    String intInput = request.getParameter("interest");
    BigDecimal intRate = new BigDecimal(intInput);

    BigDecimal compoundInt = intRate.divide(timesPerYearBG, 2, RoundingMode.HALF_UP);
    
    String initial = request.getParameter("principle");
    BigDecimal initPrinc = new BigDecimal(initial);

    String yearsInFund = request.getParameter("years");
    BigDecimal yearsInFundBD = new BigDecimal(yearsInFund);
    int currentYear = 1;

    BigDecimal endPrinc = new BigDecimal("0");
    BigDecimal startPrinc = initPrinc;
    BigDecimal intGain;
    
    List<YearlyInfo> result = new ArrayList<>();
    
  for (int i = 1; i <= timesPerYear; i++) {

            YearlyInfo current = new YearlyInfo();
            current.setCurrentYear(i);
            //System.out.println(" \n Current year is  " + currentYear);
            current.setInitialPrinciple(initPrinc);
            //System.out.printf(" Starting principal: " + initPrinc);

            for (int j = 0; j < timesPerYear; j++) {
                
                endPrinc = getNewPrinc(startPrinc, compoundInt);
                current.setEndingPrinciple(endPrinc);
                startPrinc = endPrinc;
                current.setStartingPrinciple(startPrinc);

            }
           intGain = endPrinc.subtract(initPrinc);
           current.setInterestGained(intGain);
           current.setCarryOverPrinciple(startPrinc);
           result.add(current);
        }
        model.put("YearlyObjects", result);
        return "result";
    }
    
    public BigDecimal getNewPrinc(BigDecimal start, BigDecimal interest) {
        BigDecimal oneHund = new BigDecimal("100");
        BigDecimal one = new BigDecimal("1");
        BigDecimal intCalc = interest.divide(oneHund, 2, RoundingMode.HALF_UP);
        BigDecimal intCalc2 = one.add(intCalc);
        BigDecimal calculatedPrinc = start.multiply(intCalc2);
        BigDecimal calcPricScaled = calculatedPrinc.setScale(2, RoundingMode.HALF_UP);

        /* BigDecimal calculatedPrinc = start * (1+ (interest / 100)); */
        return calcPricScaled;
    }

}
