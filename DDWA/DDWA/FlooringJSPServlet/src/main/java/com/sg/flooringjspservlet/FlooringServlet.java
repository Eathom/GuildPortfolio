/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringjspservlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
@WebServlet(name = "FlooringServlet", urlPatterns = {"/FlooringServlet"})
public class FlooringServlet extends HttpServlet {

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
        
        request.setAttribute("mtrlCost", totalMtrlCost);
        request.setAttribute("laborCost", totalLabor);
        request.setAttribute("hours", hours);
        request.setAttribute("minutes", minutes);
        request.setAttribute("totalCost", grandTotal);
        
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        
        
        
        rd.forward(request, response);
        
        
        
        
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
