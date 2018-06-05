/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalcjspservlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lizz
 */
@WebServlet(name = "InterestServlet", urlPatterns = {"/InterestServlet"})
public class InterestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


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
  request.setAttribute("YearlyObjects", result);
  
  RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
  rd.forward(request, response);
  
    }

   // public void printYearly() {
       //System.out.printf(" Ending principal: " + endPrinc);
        
       // System.out.printf(" Interest earned in year: " + intGain);
       // initPrinc = startPrinc;
     //   currentYear++;
   // }

   

    public static BigDecimal getNewPrinc(BigDecimal start, BigDecimal interest) {
        BigDecimal oneHund = new BigDecimal("100");
        BigDecimal one = new BigDecimal("1");
        BigDecimal intCalc = interest.divide(oneHund, 2, RoundingMode.HALF_UP);
        BigDecimal intCalc2 = one.add(intCalc);
        BigDecimal calculatedPrinc = start.multiply(intCalc2);
        BigDecimal calcPricScaled = calculatedPrinc.setScale(2, RoundingMode.HALF_UP);

        /* BigDecimal calculatedPrinc = start * (1+ (interest / 100)); */
        return calcPricScaled;
    }

   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
