/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.tipspringmvc;

import java.math.BigDecimal;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Lizz
 */
@Controller
public class TipController {
    @RequestMapping(value="calculate", method = RequestMethod.POST)
            public String calculate(HttpServletRequest request, Map<String,Object> model){
                
     String billInput = request.getParameter("bill");
        String tipInput = request.getParameter("tip");
        
        BigDecimal bill = new BigDecimal(billInput);
        BigDecimal tipPercent = new BigDecimal(tipInput);
        
        BigDecimal tipAmount = bill.multiply(tipPercent).divide(new BigDecimal("100"));
        BigDecimal total = bill.add(tipAmount);
        
        model.put("bill", bill);
        model.put("tipPercent", tipPercent);
        model.put("tipAmount", tipAmount);
        model.put("total", total);
        
        return "result";
            }
}
